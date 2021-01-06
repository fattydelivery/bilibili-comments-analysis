package io.github.fattydelivery.bilibilicommentsanalysis.controller;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.DBConnect;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.MySQLUtils.SaveTask;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils.Bvid2Cid;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.TaskUtils.CommentsAnalysisTimerTask;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.TimeWCToHBase.TimeWCTopology;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.WordsWCToHBase.WordsWCTopology;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.util.Timer;

import static io.github.fattydelivery.bilibilicommentsanalysis.utils.TimeWCToHBase.TimeWCTopology.*;
import static io.github.fattydelivery.bilibilicommentsanalysis.utils.WordsWCToHBase.WordsWCTopology.*;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-25-12:42
 **/

@Controller
public class AnalysisController {
    private boolean test = false;
    @GetMapping("analysis")
    public String analysis(
            @RequestParam("bvid") String bvid
    ) {
        System.out.println("[Analysis page opened] bvid:" + bvid);
        // TODO:创建分析任务
        Connection con = DBConnect.getConnection();
        if (test || !SaveTask.isExist(bvid, con)) {
            SaveTask.addTask(bvid, con);
            CommentsAnalysisTimerTask task = new CommentsAnalysisTimerTask();
            task.setBvid(bvid);
            Timer timer = new Timer(true);
            timer.schedule(task, 10000);
            try {
                System.out.println("[Submit Topology]");
                TimeTopology();
                WordsTopology();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "analysis";
    }
}
