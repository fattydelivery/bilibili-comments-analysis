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
public class AdminController {
    @RequestMapping("/admin")
    public String about() {
        System.out.println("[Admin page opened]");
        return "admin";
    }
}
