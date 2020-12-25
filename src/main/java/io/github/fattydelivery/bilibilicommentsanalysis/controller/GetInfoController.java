package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.Bvid2Cid;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-13:11
 **/

@Controller
public class GetInfoController {
    @GetMapping("/getinfo")
    @ResponseBody
    public String getInfo(
            @RequestParam("bvid") String bvid
    ) {
        String cid = Bvid2Cid.getcid(bvid);
        JSONObject info = new JSONObject();
        info.put("bvid", bvid);
        info.put("cid", cid);
        return info.toString();
    }
}
