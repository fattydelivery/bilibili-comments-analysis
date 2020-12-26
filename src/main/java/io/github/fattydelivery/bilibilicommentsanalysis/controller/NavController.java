package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-21:44
 **/
@Controller
public class NavController {
    @RequestMapping("/nav")
    public String about() {
        System.out.println("open nav page");
        return "nav";
    }
}
