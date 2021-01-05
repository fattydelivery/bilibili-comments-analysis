package io.github.fattydelivery.bilibilicommentsanalysis.utils.WordsWCToHBase;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.List;

/**
 * @program:BilibiliProject
 * @description:切割一行
 * @auther:滕畅
 * @create:2020-12-23 23:03
 **/
public class WordsSplitBolt extends BaseBasicBolt {
    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        // 根据变量名获得从spout传来的值,这里的str是spout中定义好的变量名
        String line = input.getStringByField("str");

        // 对单词进行分割
        String[] words = line.split(",");

        // 传递给下一个组件，即WordCountBolt
//        collector.emit(new Values(words[8]));
        CutIntoWords cut = new CutIntoWords();

        List<String> resList = cut.seg(words[9]);

        Object[] res = resList.toArray();

        for (int i = 0; i < res.length; i++) {

            if (res[i].equals("！")) {
                continue;
            } else {
                collector.emit(new Values(words[0],res[i]));
            }

        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // 声明本次emit出去的变量名称
        declarer.declare(new Fields("bvid","word"));
    }
}
