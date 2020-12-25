package KafkaToStormToHBase.TimeWC;

import clojure.lang.Compiler;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * @program:BilibiliProject
 * @description:切割一行
 * @auther:滕畅
 * @create:2020-12-20 23:35
 **/
public class TimeWordSplitBolt extends BaseBasicBolt {
    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        // 根据变量名获得从spout传来的值,这里的str是spout中定义好的变量名
        String line = input.getStringByField("str");

        // 对单词进行分割
        String[] words=line.split(",");

        // 截取整数部分，即精确到秒。
        int index = words[0].indexOf(".");

        // 传递给下一个组件，即WordCountBolt
        collector.emit(new Values(words[0].substring(0,index)));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // 声明本次emit出去的变量名称
        declarer.declare(new Fields("word"));
    }
}

