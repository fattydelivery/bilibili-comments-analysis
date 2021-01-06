package io.github.fattydelivery.bilibilicommentsanalysis.utils.WordsWCToHBase;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.PropertiesUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @program:bilibili-comments-analysis
 * @description:
 * @auther:滕畅
 * @create:2020-12-28 09:46
 **/
public class WordsHBaseBolt implements IRichBolt {
    private TopologyContext context;
    private OutputCollector collector;
    private Table tb;

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.context = context;
        this.collector = collector;

        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.rootdir", PropertiesUtil.getProperty("hbase.rootdir"));
        // the node of zookeeper
        conf.set("hbase.zookeeper.quorum", PropertiesUtil.getProperty("hbase.zookeeper.quorum"));
        try {
            Connection conn = ConnectionFactory.createConnection(conf);
            TableName tableName = TableName.valueOf(PropertiesUtil.getProperty("hbase.table.wordcount.name"));
            tb = conn.getTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(Tuple input) {
        String bvid = input.getString(0);
        String word = input.getString(1);
        String count = input.getString(2);
        SimpleDateFormat dateRandom = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();
        String rm = dateRandom.format(date);
        String rowkey = bvid + rm;
        byte[] row = Bytes.toBytes(rowkey);
        Put put = new Put(row);
        put.addColumn(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.wordcount.name.cf")), Bytes.toBytes("count"), Bytes.toBytes(count));
        put.addColumn(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.wordcount.name.cf")), Bytes.toBytes("word"), Bytes.toBytes(word));
        try {
            tb.put(put);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cleanup() {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
