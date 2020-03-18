package com.myimooc.activemq.boot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息服务监听类-主题模式
 *
 * @author zc 2017-07-22
 */
public class ConsumerTopicMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerTopicMessageListener.class);

    /**
     * 功能：接收到消息后，进行业务逻辑处理
     */
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.info("接收消息：" + textMessage.getText());
        } catch (JMSException e) {
            logger.info("接收消息异常");
            e.printStackTrace();
        }
    }
}
