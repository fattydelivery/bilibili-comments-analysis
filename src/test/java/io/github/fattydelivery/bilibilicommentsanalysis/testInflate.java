package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.BilibiliApiProperties;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.InflateDeflateUtil;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.RequestData;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.Rule;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-15:56
 **/
public class testInflate {
    public static void main(String[] args) {
        BilibiliApiProperties bilibiliApiProperties = new BilibiliApiProperties();
        System.out.println(bilibiliApiProperties.getBvid2cid());
        System.out.println(bilibiliApiProperties.getGetcomments());

        String url = "http://api.bilibili.com/x/v1/dm/list.so?oid=3307690";
        try {
            URL urls = new URL(url);
            InflateDeflateUtil.inflate(urls);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
