package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.BilibiliApiProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.*;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-23-16:18
 **/
public class testRequestData {
    @Test
    public static void main(String[] args) {
        BilibiliApiProperties bilibiliApiProperties = new BilibiliApiProperties();
        System.out.println(bilibiliApiProperties.getBvid2cid());
        System.out.println(bilibiliApiProperties.getGetcomments());
        Rule rule = new Rule(bilibiliApiProperties.getBvid2cid(), new String[] {"bvid"},
                new String[]{"BV1zs411S7sz"}, Rule.GET);
        System.out.println(rule.getUrl());
        JSONObject json = RequestData.getJson(rule);
        System.out.println(json.toString());
        JSONArray jsonarr = json.getJSONArray("data");
        System.out.println(jsonarr.toString());
        int cid = jsonarr.getJSONObject(0).getInt("cid");
        System.out.println(cid);

        rule = new Rule(bilibiliApiProperties.getGetcomments(), new String[] {"oid"},
                new String[] {String.valueOf(cid)}, Rule.GET);
        System.out.println(rule.getUrl());
        System.out.println(RequestData.getXml(rule).toString());
    }
}
