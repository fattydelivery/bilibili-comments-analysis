package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import com.alibaba.fastjson.JSON;
import io.github.fattydelivery.bilibilicommentsanalysis.entity.Comment;
import io.github.fattydelivery.bilibilicommentsanalysis.properties.BilibiliApiProperties;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.Bvid2Cid;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.GetComments;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.RequestData;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.Rule;
import org.jdom.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-13:11
 **/
@Controller
public class GetCommentsController {
    @GetMapping("/getcomments")
    @ResponseBody
    public String getComment(
            @RequestParam("bvid") String bvid
    ) {
        // TODO: 前端ajax计时更新
        String cid = Bvid2Cid.getcid(bvid);
        BilibiliApiProperties bilibiliApiProperties = new BilibiliApiProperties();
        Rule rule = new Rule(bilibiliApiProperties.getGetcomments(), new String[] {"oid"},
                new String[] {cid}, Rule.GET);
        // System.out.println(rule.getUrl());
        System.out.println("[GetComments api called] bvid:" + bvid);
        Document doc = RequestData.getXml(rule);
        ArrayList<Comment> comments = GetComments.Xml2ArrayList(doc);
        return JSON.toJSON(comments).toString();
    }
}
