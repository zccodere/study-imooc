package com.myimooc.jmsspring.comfig;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.MessageListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.myimooc.jmsspring.consumer.ConsumerMessageListener;
import com.myimooc.jmsspring.consumer.ConsumerTopicMessageListener;

/**
 * 消息消费者配置类
 * @author ZhangCheng on 2017-07-22
 *
 */
@Configuration
public class ConsumerConfig {
	
	@Resource(name = "connectionFactory")
	private SingleConnectionFactory singleConnectionFactory;
	@Resource(name = "queueDestination")
	private Destination queueDestination;
	@Resource(name = "consumerMessageListener")
	private ConsumerMessageListener consumerMessageListener;
	@Resource(name = "topicDestination")
	private Destination topicDestination;
	@Resource(name = "topicConsumerMessageListener")
	private MessageListener topicConsumerMessageListener;
	
	/**
	 * 功能：配置消息监听器-队列模式
	 */
	@Bean(name = "consumerMessageListener")
	public ConsumerMessageListener consumerMessageListener(){
		ConsumerMessageListener consumerMessageListener= new ConsumerMessageListener();
		return consumerMessageListener;
	}
	
	/**
	 * 功能：配置Spring提供的消息监听容器-队列模式
	 */
	@Bean
	public DefaultMessageListenerContainer defaultMessageListenerContainer(){
		DefaultMessageListenerContainer messageListenerContainer= new DefaultMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(singleConnectionFactory);
		messageListenerContainer.setDestination(queueDestination);
		messageListenerContainer.setMessageListener(consumerMessageListener);
		return messageListenerContainer;
	}
	
	/**
	 * 功能：配置消息监听器-主题模式
	 */
	@Bean(name = "topicConsumerMessageListener")
	public MessageListener topicConsumerMessageListener(){
		ConsumerTopicMessageListener consumerMessageListener= new ConsumerTopicMessageListener();
		return consumerMessageListener;
	}
	
	/**
	 * 功能：配置Spring提供的消息监听容器-主题模式
	 */
	@Bean(name = "topicDefaultMessageListenerContainer")
	public DefaultMessageListenerContainer topicDefaultMessageListenerContainer(){
		DefaultMessageListenerContainer messageListenerContainer= new DefaultMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(singleConnectionFactory);
		messageListenerContainer.setDestination(topicDestination);
		messageListenerContainer.setMessageListener(topicConsumerMessageListener);
		return messageListenerContainer;
	}
}
