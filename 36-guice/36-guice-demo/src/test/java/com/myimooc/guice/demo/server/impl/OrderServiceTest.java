package com.myimooc.guice.demo.server.impl;

import javax.inject.Inject;

import com.myimooc.guice.demo.server.OrderService;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

/**
 * @title 测试类
 * @describe 模拟订单系统
 * @author zc
 * @version 1.0 2017-10-15
 */
public class OrderServiceTest {
	
	@Inject
	private OrderService orderService;
	
	@Before
	public void setUp(){
		Guice.createInjector(new ServerModule())
			 .injectMembers(this);
	}
	
	@Test
	public void TestSendToPayment(){
		orderService.sendToPayment(789L);
	}
}
