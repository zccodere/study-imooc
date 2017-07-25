package com.myimooc.jmsspring.comfig;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * 消息生产者配置类
 * @author ZhangCheng on 2017-07-22
 *
 */
@Configuration
public class ProducerConfig {
	
	@Resource(name = "connectionFactory")
	private SingleConnectionFactory singleConnectionFactory;
	
	/**
	 * 功能：配置Spring提供JmsTemplate，用于发送消息
	 */
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate= new JmsTemplate();
		jmsTemplate.setConnectionFactory(singleConnectionFactory);
		return jmsTemplate;
	}
}
