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
        GetHeatMap getHeatMap = new GetHeatMap();
        System.out.println(getHeatMap.getKV());

        GetWordCloud getWordCloud = new GetWordCloud();
        System.out.println(getWordCloud.getKV());
    }
}