package com.myimooc.guice.demo.server;

/**
 * @title 订单业务接口类
 * @describe 模拟订单系统
 * @author zc
 * @version 1.0 2017-10-15
 */
public interface OrderService {

	/**
	 * 发送订单
	 * @param orderId 订单
	 */
	void sendToPayment(long orderId);
	
}
