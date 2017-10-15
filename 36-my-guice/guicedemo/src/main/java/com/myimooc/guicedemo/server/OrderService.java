package com.myimooc.guicedemo.server;

/**
 * @title 订单业务接口类
 * @describe 模拟订单系统
 * @author zc
 * @version 1.0 2017-10-15
 */
public interface OrderService {

	void sendToPayment(long orderId);
	
}
