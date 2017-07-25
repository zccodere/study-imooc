package com.myimooc.jmsspring.producer;

/**
 * 消息发送服务
 * @author ZhangCheng on 2017-07-22
 *
 */
public interface ProducerService {
	
	/**
	 * 功能：发送字符串到消息服务-队列模式
	 */
	void sendMessageQueue(String message);
	
	/**
	 * 功能：发送字符串到消息服务-主题模式
	 */
	void sendMessageTopic(String message);
}
