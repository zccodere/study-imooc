package com.myimooc.activemq.boot.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * 消息发送服务实现类
 *
 * @author zc 2017-07-22
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

    /**
     * 注入在 ProducerConfig类配置的JMS模版类
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 注入在 ProducerConfig类配置的目的地-队列模式
     */
    @Resource(name = "queueDestination")
    private Destination queueDestination;
    /**
     * 注入在 ProducerConfig类配置的目的地-主题模式
     */
    @Resource(name = "topicDestination")
    private Destination topicDestination;

    @Override
    public void sendMessageQueue(String message) {
        jmsTemplate.send(queueDestination, session -> {
            TextMessage textMessage = session.createTextMessage(message);
            logger.info("队列模式-发送消息：" + textMessage.getText());
            return textMessage;
        });
    }

    @Override
    public void sendMessageTopic(String message) {
        jmsTemplate.send(topicDestination, session -> {
            TextMessage textMessage = session.createTextMessage(message);
            logger.info("主题模式-发送消息：" + textMessage.getText());
            return textMessage;
        });
    }
}
