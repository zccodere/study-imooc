package com.myimooc.kafka.example.producer;

import com.alibaba.fastjson.JSON;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 生产者
 *
 * @author zc
 * @date 2018/09/09
 */
@Component
public class SimpleProducer<T> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String key, T entity) {
        logger.info("发送消息入参：{}", entity);

        // 将任意对象转换为JSON字符串进行消息发送
        ProducerRecord<String, String> record = new ProducerRecord<>(
                topic,
                key,
                JSON.toJSONString(entity)
        );

        long startTime = System.currentTimeMillis();
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("消息发送失败：", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                RecordMetadata metadata = result.getRecordMetadata();

                StringBuilder record = new StringBuilder(128);
                record.append("message(");
                record.append("key = ").append(key).append(",");
                record.append("message = ").append(entity).append(")");
                record.append("send to partition(").append(metadata.partition()).append(")");
                record.append("with offset(").append(metadata.offset()).append(")");
                record.append("in ").append(elapsedTime).append(" ms");
                logger.info("消息发送成功：{}", record.toString());
            }
        });
    }
}
