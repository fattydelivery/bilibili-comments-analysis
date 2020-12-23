package io.github.fattydelivery.bilibilicommentsanalysis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-23-18:40
 **/

public class BilibiliApiProperties {
    private String bvid2cid, getcomments;
    private String filePath = "/bilibiliapi.properties";

    public BilibiliApiProperties() {
        Properties properties = new Properties();
        try {
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = BilibiliApiProperties.class.getClass().getResourceAsStream(this.filePath);
            // 使用properties对象加载输入流
            properties.load(in);
            //获取key对应的value值
            this.bvid2cid = properties.getProperty("com.bilibili.api.bvid2cid");
            this.getcomments = properties.getProperty("com.bilibili.api.getcomments");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBvid2cid() {
        return bvid2cid;
    }

    public void setBvid2cid(String bvid2cid) {
        this.bvid2cid = bvid2cid;
    }

    public String getGetcomments() {
        return getcomments;
    }

    public void setGetcomments(String getcomments) {
        this.getcomments = getcomments;
    }
}
