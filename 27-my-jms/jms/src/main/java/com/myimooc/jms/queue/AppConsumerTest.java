package com.myimooc.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * App 消费者-队列模式-集群配置测试
 * @author ZhangCheng on 2017-07-22
 *
 */
public class AppConsumerTest {
	/** failover 为状态转移的存在部分
	 * */
	private static final String URL = "failover:(tcp://127.0.0.1:61616,tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
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
		
		// 5.创建一个目标
		Destination destination = session.createQueue(QUEUE_NAME);
		
		// 6.创建一个消费者
		MessageConsumer consumer = session.createConsumer(destination);
		
		// 7.创建一个监听器
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				try {
					System.out.println("接收消息：" + textMessage.getText());
				} catch (JMSException e) {
					System.out.println("接收消息异常：");
					e.printStackTrace();
				}
			}
		});
		
		// 8.关闭连接
		//connection.close();
	}
	
}
