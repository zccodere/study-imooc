package com.myimooc.guicedemo.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.myimooc.guicedemo.server.OrderService;
import com.myimooc.guicedemo.server.PaymentService;
import com.myimooc.guicedemo.server.PriceService;

/**
 * @title ServerModule类
 * @describe 绑定依赖
 * @author zc
 * @version 1.0 2017-10-15
 */
public class ServerModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(OrderService.class).to(OrderServiceImpl.class);
		bind(PaymentService.class).to(PaymentServiceImpl.class);
		bind(PriceService.class).to(PriceServiceImpl.class);
	}
	
	@Provides 
	@SessionId
	Long generateSessionId(){
		return System.currentTimeMillis();
	}
}
