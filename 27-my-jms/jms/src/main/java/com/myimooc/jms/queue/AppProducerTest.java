package com.myimooc.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * App 生产者-队列模式-集群配置测试
 * @author ZhangCheng on 2017-07-25
 *
 */
public class AppProducerTest {
	/** failover 为状态转移的存在部分
	 * 因a节点只作为消费者使用，所以这里不配置61616节点了。
	 * */
	private static final String URL = "failover:(tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
	/** 指定队列的名称 */
	private static final String QUEUE_NAME = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		
		// 1.创建ConnectionFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		
		// 2.创建Connection
		Connection connection = connectionFactory.createConnection();
		
		// 3.启动连接
		connection.start();
		
		// 4.创建会话（第一个参数：是否在事务中处理）
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 5. 创建一个目标
		Destination destination = session.createQueue(QUEUE_NAME);
		
		// 6.创建一个生产者
		MessageProducer producer = session.createProducer(destination);
		
		for (int i = 0; i < 100; i++) {
			
			// 7.创建消息
			TextMessage textMessage = session.createTextMessage("test" + i);
			
			// 8.发布消息
			producer.send(textMessage);
			
			System.out.println("消息发送：" + textMessage.getText());
		}
		
		// 9.关闭连接
		connection.close();
	}
	
}
