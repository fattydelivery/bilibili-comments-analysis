package io.github.fattydelivery.bilibilicommentsanalysis.utils.WordsWCToHBase;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.TimeWCToHBase.TimeWCBolt;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:BilibiliProject
 * @description:统计词频
 * @auther:滕畅
 * @create:2020-12-23 23:03
 **/
public class WordsWCBolt extends BaseBasicBolt {
    public Logger log = LoggerFactory.getLogger(TimeWCBolt.class);

    private static Map<String, Integer> map = new HashMap<String, Integer>();

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        // 根据变量名称获得上一个bolt传递过来的数据
        String bvid = input.getStringByField("bvid");
        String word = input.getStringByField("word");

        Integer count = map.get(word);
        if (count == null) {
            map.put(word, 1);
        } else {
            count++;
            map.put(word, count);
        }

        StringBuilder msg = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            msg.append(entry.getKey() + " = " + entry.getValue()).append(", ");
            collector.emit(new Values(bvid, entry.getKey(), entry.getValue().toString()));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info(msg.toString());
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("bvid", "word", "count"));
    }
}
