package io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils;

import io.github.fattydelivery.bilibilicommentsanalysis.entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-14:47
 **/
public class SaveComments {
    public static ArrayList<Comment> CompareRecord(String bvid, ArrayList<Comment> comments, Connection con) {
        ArrayList<Comment> res = null;
        String sql = "select commentdmid from comments where bvid=? order by commentdmid desc";
        try {
            PreparedStatement prestm = con.prepareStatement(sql);
            prestm.setString(1, bvid);
            ResultSet resultSet = prestm.executeQuery();
            if (resultSet.next()) {
                String lastdmid = resultSet.getString(1);
                for (int i = 0; i < comments.size(); i++) {
                    if (comments.get(i).getCommentDmId().toString().equals(lastdmid)) {
                        break;
                    } else {
                        if (res == null) res = new ArrayList<Comment>();
                        res.add(comments.get(i));
                    }
                }
            } else {
                return comments;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void SaveToMySQL(String bvid, ArrayList<Comment> comments, Connection con) {
        String sql = "insert into comments values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prestm = con.prepareStatement(sql);
            con.setAutoCommit(false);
            for (int i = 0; i < comments.size(); i++) {
                Comment comment = comments.get(i);
                prestm.setString(1, bvid);
                prestm.setFloat(2, comment.getAppearanceTime());
                prestm.setInt(3, comment.getCommentType());
                prestm.setInt(4, comment.getCommentSize());
                prestm.setInt(5, comment.getCommentColor());
                prestm.setString(6, String.valueOf(comment.getSendTimestamp()));
                prestm.setInt(7, comment.getPoolType());
                prestm.setString(8, comment.getSenderUid());
                prestm.setString(9, String.valueOf(comment.getCommentDmId()));
                prestm.setString(10, comment.getCommentText());
                prestm.addBatch();
            }
            prestm.executeBatch();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
