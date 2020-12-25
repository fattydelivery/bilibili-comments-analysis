package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-13:12
 **/

@Controller
public class GetAnalysisDataController {
    @GetMapping("/getanalysisdata")
    @ResponseBody
    public String getAnalysisData(
            @RequestParam("bvid") String bvid
    ) {
        return null;
    }
}
