package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.WordsWCToHBase.WordsWCTopology;

/**
 * @program:bilibili-comments-analysis
 * @description:
 * @auther:滕畅
 * @create:2021-01-01 23:58
 **/
public class testWordsWCToHBase {
    public static void main(String[] args) throws Exception {
        WordsWCTopology topology=new WordsWCTopology();
        topology.WordsTopology();
    }
}
