package io.github.fattydelivery.bilibilicommentsanalysis.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-15:27
 **/
public class HBaseProperties {
    private String ip, port;
    private String filePath = "/cluster.properties";

    public HBaseProperties() {
        Properties properties = new Properties();
        try {
            InputStream in = TempFileProperties.class.getClass().getResourceAsStream(this.filePath);
            properties.load(in);

            this.ip = properties.getProperty("hbase.ip");
            this.port = properties.getProperty("hbase.port");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
