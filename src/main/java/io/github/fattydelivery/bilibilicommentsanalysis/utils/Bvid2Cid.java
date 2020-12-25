package io.github.fattydelivery.bilibilicommentsanalysis.utils;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.BilibiliApiProperties;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-23-21:45
 **/

public class Bvid2Cid {
    public static String getcid(String bvid) {
        BilibiliApiProperties bilibiliApiProperties = new BilibiliApiProperties();
        // System.out.println(bilibiliApiProperties.getBvid2cid());
        // System.out.println(bilibiliApiProperties.getGetcomments());
        Rule rule = new Rule(bilibiliApiProperties.getBvid2cid(), new String[] {"bvid"},
                new String[]{bvid}, Rule.GET);
        // System.out.println(rule.getUrl());
        JSONObject json = RequestData.getJson(rule);
        // System.out.println(json.toString());
        JSONArray jsonarr = json.getJSONArray("data");
        // System.out.println(jsonarr.toString());
        String cid = String.valueOf(jsonarr.getJSONObject(0).getInt("cid"));
        // System.out.println(cid);
        return cid;
    }
}
