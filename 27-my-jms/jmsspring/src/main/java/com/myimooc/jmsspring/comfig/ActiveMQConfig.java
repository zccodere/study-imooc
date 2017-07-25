package com.myimooc.jmsspring.comfig;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;

/**
 * ActiveMQ消息服务配置类
 * @author ZhangCheng on 2017-07-22
 *
 */
@Configuration
public class ActiveMQConfig {
	
	/** 指定ActiveMQ服务的地址 */
	private static final String URL = "tcp://127.0.0.1:61616";
	/** 指定队列的名称 */
	private static final String QUEUE_NAME = "queue";
	/** 指定主题的名称 */
	private static final String TOPIC_NAME = "topic";
	
	/**
	 * 功能：配置ActiveMQ提供的ConnectionFactory
	 */
	@Bean(name = "targetConnectionFactory")
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory activeMQConnectionFactory= new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(URL);
		return activeMQConnectionFactory;
	}
	
	/**
	 * 功能：配置Spring提供的连接池ConnectionFactory
	 */
	@Bean(name = "connectionFactory")
	public SingleConnectionFactory singleConnectionFactory(){
		SingleConnectionFactory connectionFactory = new SingleConnectionFactory();
		connectionFactory.setTargetConnectionFactory(activeMQConnectionFactory());
		return connectionFactory;
	}
	
	/**
	 * 功能：配置ActiveMQ队列模式的目的地，点对点模式
	 */
	@Bean(name = "queueDestination")
	public ActiveMQQueue activeMQQueue(){
		ActiveMQQueue activeMQQueue= new ActiveMQQueue(QUEUE_NAME);
		return activeMQQueue;
	}
	
	/**
	 * 功能：配置ActiveMQ主题模式的目的地，发布订阅模式
	 */
	@Bean(name = "topicDestination")
	public ActiveMQTopic activeMQTopic(){
		ActiveMQTopic activeMQTopic= new ActiveMQTopic(TOPIC_NAME);
		return activeMQTopic;
	}
}
