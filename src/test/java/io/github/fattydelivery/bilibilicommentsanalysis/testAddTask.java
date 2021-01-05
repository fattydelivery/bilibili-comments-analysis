package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.DBConnect;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.SaveTask;

import java.sql.Connection;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-15:58
 **/
public class testAddTask {
    public static void main(String[] args) {
        String bvid = "hahahahaha";
        Connection con = DBConnect.getConnection();
        // 感谢老板的小心心
        System.out.println(SaveTask.isExist(bvid, con));
        SaveTask.addTask(bvid, con);
        System.out.println(SaveTask.isExist(bvid, con));
    }
}
