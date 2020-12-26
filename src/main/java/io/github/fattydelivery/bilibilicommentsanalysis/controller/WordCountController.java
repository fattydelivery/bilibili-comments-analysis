package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-26-17:28
 **/
public class WordCountController {
    @GetMapping("/wordcount")
    @ResponseBody
    public String getAnalysisData(
            @RequestParam("bvid") String bvid
    ) {
        String str = "";
        return str;
    }
}
