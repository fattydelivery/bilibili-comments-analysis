package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson.GetHeatMap;
import io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson.GetWordCloud;

import java.io.IOException;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-16:26
 **/
public class testGetHeatMap {
    public static void main(String[] args) {
        String bvid = "BV1Jf4y1y7wQ";
        GetHeatMap getHeatMap = new GetHeatMap(bvid);
        System.out.println(getHeatMap.getKV());

        GetWordCloud getWordCloud = new GetWordCloud(bvid);
        System.out.println(getWordCloud.getKV());
    }
}
