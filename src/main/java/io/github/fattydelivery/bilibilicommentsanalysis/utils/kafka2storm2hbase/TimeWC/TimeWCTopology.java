package io.github.fattydelivery.bilibilicommentsanalysis.utils.kafka2storm2hbase.TimeWC;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.kafka.*;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * @program:BilibiliProject
 * @description:
 * @auther:滕畅
 * @create:2020-12-20 23:35
 **/
public class TimeWCTopology {

    public static void main(String[] args) throws Exception {
        //1.创建Topology的构建器
        TopologyBuilder topologyBuilder = new TopologyBuilder();

        // BrokerHosts接口有2个实现类StaticHosts和ZkHosts,ZkHosts会定时(默认60秒)从ZK中更新brokers的信息,StaticHosts是则不会
        // 要注意这里的第二个参数brokerZkPath要和kafka中的server.properties中配置的zookeeper.connect对应
        // 因为这里是需要在zookeeper中找到brokers znode
        // 默认kafka的brokers znode是存储在zookeeper根目录下
        BrokerHosts brokerHosts = new ZkHosts("hadoop000:2181,hadoop000:2182,hadoop000:2183",
                "/kafka/brokers");

        // 定义spoutConfig
        // 第一个参数hosts是上面定义的brokerHosts
        // 第二个参数topic是该Spout订阅的topic名称
        // 第三个参数zkRoot是存储消费的offset(存储在ZK中了),当该topology故障重启后会将故障期间未消费的message继续消费而不会丢失(可配置)
        // 第四个参数id是当前spout的唯一标识
        SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, "project", "/project", "timewc");

        // 定义kafkaSpout如何解析数据,这里是将kafka的producer send的数据放入到String
        // 类型的str变量中输出,这个str是StringSchema定义的变量名称
        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());

        // 设置spout
        topologyBuilder.setSpout("kafkaSpout", new KafkaSpout(spoutConfig));
        // 设置bolt
        topologyBuilder.setBolt("TimeWordSplitBolt", new TimeWordSplitBolt()).shuffleGrouping("kafkaSpout");
        // 设置bolt
        topologyBuilder.setBolt("TimeWCBolt", new TimeWCBolt()).fieldsGrouping("TimeWordSplitBolt", new Fields("word"));

        //启动Topology
        Config conf = new Config();
        //创建一个topology
        StormTopology topology = topologyBuilder.createTopology();
        //本地模式启动集群
        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("TimeWCTopology", conf, topology);
    }
}


