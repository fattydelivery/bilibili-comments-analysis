package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-12:43
 **/

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("[Home page opened]");
        return "index";
    }
}
