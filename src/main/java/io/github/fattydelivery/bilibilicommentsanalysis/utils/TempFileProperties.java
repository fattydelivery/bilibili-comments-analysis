package io.github.fattydelivery.bilibilicommentsanalysis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-17:28
 **/
public class TempFileProperties {
    private String xmlPath, csvPath;
    private String filePath = "/tempfile.properties";

    public TempFileProperties() {
        Properties properties = new Properties();
        try {
            InputStream in = TempFileProperties.class.getClass().getResourceAsStream(this.filePath);
            properties.load(in);

            this.csvPath = properties.getProperty("path.temp.csv");
            this.xmlPath = properties.getProperty("path.temp.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }
}
