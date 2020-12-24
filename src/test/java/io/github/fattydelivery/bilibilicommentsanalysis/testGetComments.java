package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.*;
import org.jdom.Document;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-16:33
 **/
public class testGetComments {
    public static void main(String[] args) {
        String bvid = "BV1zs411S7sz";
        String cid = Bvid2Cid.getcid(bvid);
        BilibiliApiProperties bilibiliApiProperties = new BilibiliApiProperties();
        TempFileProperties tempFileProperties = new TempFileProperties();

        Rule rule = new Rule(bilibiliApiProperties.getGetcomments(), new String[] {"oid"},
                new String[] {cid}, Rule.GET);
        System.out.println(rule.getUrl());
        Document doc = RequestData.getXml(rule);
        GetComments.Xml2ArrayList(doc);
        GetComments.Xml2Csv(doc, "F:\\_\\2020-2021-1\\10NIIT-Project\\bilibili-comments-analysis\\src\\main\\resources"
                + tempFileProperties.getCsvPath(), "list.csv");
        GetComments.Xml2Txt(doc, "F:\\_\\2020-2021-1\\10NIIT-Project\\bilibili-comments-analysis\\src\\main\\resources"
                + tempFileProperties.getCsvPath(), "list.txt");
    }
}
