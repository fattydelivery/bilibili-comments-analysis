package io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-15:52
 **/
public class SaveTask {
    public static boolean isExist(String bvid, Connection con) {
        String sql = "select * from tasks where bvid=?";
        try {
            PreparedStatement prestm = con.prepareStatement(sql);
            prestm.setString(1, bvid);
            ResultSet resultSet = prestm.executeQuery();
            if (resultSet.next()) return true; else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    public static void addTask(String bvid, Connection con) {
        String sql = "insert into tasks values(?)";
        try {
            PreparedStatement prestm = con.prepareStatement(sql);
            prestm.setString(1, bvid);
            prestm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean havaDone(Connection con) {
        String sql = "select * from tasks";
        try {
            PreparedStatement prestm = con.prepareStatement(sql);
            ResultSet resultSet = prestm.executeQuery();
            if (resultSet.next()) return true; else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }
}
