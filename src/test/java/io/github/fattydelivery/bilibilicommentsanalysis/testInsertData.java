package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.entity.Comment;
import io.github.fattydelivery.bilibilicommentsanalysis.properties.BilibiliApiProperties;
import io.github.fattydelivery.bilibilicommentsanalysis.properties.TempFileProperties;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.DBConnect;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.SaveComments;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.Bvid2Cid;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.GetComments;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.RequestData;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.Rule;
import org.jdom.Document;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-15:30
 **/
public class testInsertData {
    public static void main(String[] args) {
        String bvid = "BV1zs411S7sz";
        String cid = Bvid2Cid.getcid(bvid);
        BilibiliApiProperties bilibiliApiProperties = new BilibiliApiProperties();
        TempFileProperties tempFileProperties = new TempFileProperties();

        Rule rule = new Rule(bilibiliApiProperties.getGetcomments(), new String[]{"oid"},
                new String[]{cid}, Rule.GET);
        System.out.println(rule.getUrl());
        Document doc = RequestData.getXml(rule);
        ArrayList<Comment> comments = GetComments.Xml2ArrayList(doc);
        System.out.println(comments.size());
        Connection con = DBConnect.getConnection();
        ArrayList<Comment> res = SaveComments.CompareRecord(bvid, comments, con);
        for (int i = 0; i < res.size(); i++) System.out.println(res.get(i));
        System.out.println(res.size());
        SaveComments.SaveToMySQL(bvid, res, con);
    }
}
