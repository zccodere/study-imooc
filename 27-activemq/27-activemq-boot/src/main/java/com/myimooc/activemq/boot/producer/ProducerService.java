package com.myimooc.activemq.boot.producer;

/**
 * 消息发送服务
 *
 * @author zc 2017-07-22
 */
public interface ProducerService {

    /**
     * 功能：发送字符串到消息服务-队列模式
     *
     * @param message 消息
     */
    void sendMessageQueue(String message);

    /**
     * 功能：发送字符串到消息服务-主题模式
     *
     * @param message 消息
     */
    void sendMessageTopic(String message);
}
