package com.myimooc.guice.demo.server.impl;

import com.myimooc.guice.demo.server.PaymentService;

/**
 * @title 支付业务实现类
 * @describe 模拟订单系统
 * @author zc
 * @version 1.0 2017-10-15
 */
public class PaymentServiceImpl implements PaymentService {

	@Override
	public void pay(long orderId, long price, Long sessionId) {
	}
}
