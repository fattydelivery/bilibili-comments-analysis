package io.github.fattydelivery.bilibilicommentsanalysis.properties;

/**
 * @program:bilibili-comments-analysis
 * @description:
 * @auther:滕畅
 * @create:2021-01-01 23:39
 **/

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program:bilibili-comments-analysis
 * @description:测试文件工具类
 * @auther:滕畅
 * @create:2021-01-01 23:56
 **/
public class PropertiesUtil {
    //单例模式
    private PropertiesUtil(){}
    //静态配置对象
    public static Properties props = null;
    //初始化对象
    static {
        InputStream in = ClassLoader.getSystemResourceAsStream("cluster.properties");
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
