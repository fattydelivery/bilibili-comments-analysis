package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.BilibiliApiProperties;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.Bvid2Cid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-12:42
 **/

@Controller
public class AnalysisController {
    @GetMapping("analysis")
    public String analysis(
            @RequestParam("bvid") String bvid
    ) {
        System.out.println("analysis page");
        System.out.println(bvid);
        System.out.println(Bvid2Cid.getcid(bvid));
        return "analysis";
    }
}
