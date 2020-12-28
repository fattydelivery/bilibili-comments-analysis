package io.github.fattydelivery.bilibilicommentsanalysis.utils.kafka2storm2hbase.WordsWCToHBase;

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
        conf.set("hbase.rootdir", "hdfs://hadoop000:9000/hbase");
        // the node of zookeeper
        conf.set("hbase.zookeeper.quorum", "hadoop000:2181");
        try {
            Connection conn = ConnectionFactory.createConnection(conf);
            TableName tableName = TableName.valueOf("WordsWC");
            tb = conn.getTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(Tuple input) {
        String word = input.getString(0);
        String count = input.getString(1);
        SimpleDateFormat dateRandom = new SimpleDateFormat("yyMMddHHmmss");
        Date date=new Date();
        String rowkey=dateRandom.format(date);
        byte[] row = Bytes.toBytes(rowkey);
        Put put = new Put(row);
        put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("count"), Bytes.toBytes(count));
        put.addColumn(Bytes.toBytes("cf"),Bytes.toBytes("word"),Bytes.toBytes(word));
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
