package com.myimooc.kafka.example.consumer;

import com.alibaba.fastjson.JSONObject;
import com.myimooc.kafka.example.common.MessageEntity;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消费者
 *
 * @author zc
 * @date 2018/09/09
 */
@Component
public class SimpleConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = "${kafka.topic.default}")
    public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        //判断是否NULL
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            //获取消息
            Object message = kafkaMessage.get();

            MessageEntity messageEntity = JSONObject.parseObject(message.toString(), MessageEntity.class);

            logger.info("接收消息Topic：{}", topic);
            logger.info("接收消息Record：{}", record);
            logger.info("接收消息Message：{}", messageEntity);
        }
    }

}
