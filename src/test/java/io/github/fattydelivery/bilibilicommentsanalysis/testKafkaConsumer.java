package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.FlumeToKafka.KafkaConsumer;

/**
 * @program:bilibili-comments-analysis
 * @description:
 * @auther:滕畅
 * @create:2021-01-01 23:41
 **/
public class testKafkaConsumer {
    public static void main(String[] args) {
        KafkaConsumer kafkaConsumer=new KafkaConsumer();
        kafkaConsumer.Consumer();
    }

}
