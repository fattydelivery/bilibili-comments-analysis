package io.github.fattydelivery.bilibilicommentsanalysis.utils.KafkaUtils;

import io.github.fattydelivery.bilibilicommentsanalysis.entity.Comment;
import io.github.fattydelivery.bilibilicommentsanalysis.properties.PropertiesUtil;
import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2021-01-05-21:27
 **/
public class SendToTopic {

    private SendToTopic() {
    }

    private static KafkaProducer<String, String> producer;
    private static Properties props;

    static {
        props = new Properties();
        props.put("bootstrap.servers", PropertiesUtil.getProperty("kafka.cluster")); //kafka集群，broker-list
        props.put("acks", "all");
        props.put("retries", 1); //重试次数
        props.put("batch.size", 16384); //批次大小
        props.put("linger.ms", 1); //等待时间
        props.put("buffer.memory", 33554432); //RecordAccumulator缓冲区大小
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    public static void send(String bvid, ArrayList<Comment> comments) {
        System.out.println("[Kafka Producer called]");
        for (int i = 0; i < comments.size(); i++) {
            producer.send(new ProducerRecord<String, String>(PropertiesUtil.getProperty("kafka.topic.name"), bvid,
                            bvid + "," + comments.get(i).toCsv()),
                    new Callback() {
                        //回调函数，该方法会在Producer收到ack时调用，为异步调用
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if (exception == null) {
                                System.out.println("[KAFKA PRODUCER] success -> " + metadata.offset());
                            } else {
                                exception.printStackTrace();
                            }
                        }
                    });
        }
    }
}
