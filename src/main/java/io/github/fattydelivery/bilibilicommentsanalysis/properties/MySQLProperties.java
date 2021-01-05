package io.github.fattydelivery.bilibilicommentsanalysis.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-14:08
 **/
public class MySQLProperties {
    //单例模式
    private MySQLProperties(){}
    //静态配置对象
    public static Properties props = null;
    //初始化对象
    static {
        InputStream in = ClassLoader.getSystemResourceAsStream("database.properties");
        props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获得配置属性
    public static String getProperty(String key){
        return props.getProperty(key);
    }
}
