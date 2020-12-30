package io.github.fattydelivery.bilibilicommentsanalysis.utils.FlumeToKafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Arrays;
import java.util.Properties;

/**
 * @program:BilibiliProject
 * @description:kafka消费flume采集到的数据
 * @auther:滕畅
 * @create:2020-12-24 20:18
 **/
public class KafkaConsumer {
    public static void main(String[] args) {

        //1.创建消费者配置信息
        Properties properties = new Properties();

        //2.给配置信息赋值

        //连接的集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop000:9092,hadoop000:9093,hadoop000:9094");
        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //自动提交的延时
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");

        //Key,Value的反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "bigdata");

        //创建消费者
        org.apache.kafka.clients.consumer.KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(properties);

        //订阅主题
        consumer.subscribe(Arrays.asList("project"));

        //获取数据
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

            //解析并打印consumerRecords
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {

                System.out.println(consumerRecord.value());

            }
        }

    }
}
