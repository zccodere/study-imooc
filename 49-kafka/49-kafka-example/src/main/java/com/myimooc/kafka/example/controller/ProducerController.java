package com.myimooc.kafka.example.controller;

import com.alibaba.fastjson.JSON;
import com.myimooc.kafka.example.common.ErrorCode;
import com.myimooc.kafka.example.common.MessageEntity;
import com.myimooc.kafka.example.common.Response;
import com.myimooc.kafka.example.producer.SimpleProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产者Controller
 *
 * @author zc
 * @date 2018/09/09
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SimpleProducer<MessageEntity> simpleProducer;

    @Value("${kafka.topic.default}")
    private String topic;

    private static final String KEY = "key";

    @PostMapping("/send")
    public Response sendKafka(@RequestBody MessageEntity message) {
        try {
            logger.info("kafka的消息：{}", JSON.toJSONString(message));
            this.simpleProducer.send(topic, KEY, message);
            logger.info("kafka消息发送成功！");
            return new Response(ErrorCode.SUCCESS, "kafka消息发送成功");
        } catch (Exception ex) {
            logger.error("kafka消息发送失败：", ex);
            return new Response(ErrorCode.EXCEPTION, "kafka消息发送失败");
        }
    }
}
