package io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.MySQLProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-14:07
 **/
public class DBConnect {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        String url = MySQLProperties.getProperty("db.mysql.url");
        String username = MySQLProperties.getProperty("db.mysql.username");
        String password = MySQLProperties.getProperty("db.mysql.password");
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
