package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-26-17:27
 **/

@Controller
public class HeatmapController {
    @GetMapping("/heatmap")
    @ResponseBody
    public String getAnalysisData(
            @RequestParam("bvid") String bvid
    ) {
        String str = "{\"1\":0,\"2\":0,\"3\":200,\"4\":0,\"5\":0,\"6\":0,\"7\":0,\"8\":0,\"9\":0,\"10\":0,\"11\":0,\"12\":0,\"13\":0,\"14\":0,\"15\":100,\"16\":0,\"17\":0,\"18\":0,\"19\":0,\"20\":0,\"21\":0,\"22\":0,\"23\":0,}";
        return str;
    }
}
