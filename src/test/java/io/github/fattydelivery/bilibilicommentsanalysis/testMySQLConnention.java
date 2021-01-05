package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-14:24
 **/
public class testMySQLConnention {
    public static void main(String[] args) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from comments;";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) System.out.println(resultSet.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
