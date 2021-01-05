package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson.GetWordCloud;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-26-17:28
 **/

@Controller
public class WordCountController {
    @GetMapping("/wordcount")
    @ResponseBody
    public String getAnalysisData(
            @RequestParam("bvid") String bvid
    ) {
        // TODO:从HBASE中获取数据
        // String str = "{\"tom\":\"3\",\"amy\":\"5\"}";
        // return str;
        System.out.println("[Getwordcount api called] bvid:" + bvid);
        GetWordCloud getWordCloud = new GetWordCloud(bvid);
        // System.out.println(getWordCloud.getKV());
        return getWordCloud.getKV();
    }
}
