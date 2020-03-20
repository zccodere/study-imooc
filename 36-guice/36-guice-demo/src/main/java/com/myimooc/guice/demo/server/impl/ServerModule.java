package com.myimooc.guice.demo.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import com.myimooc.guice.demo.server.OrderService;
import com.myimooc.guice.demo.server.PaymentService;
import com.myimooc.guice.demo.server.PriceService;

/**
 * ServerModule类；绑定依赖
 *
 * @author zc 2017-10-15
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
    }

    @Provides
    @SessionId
    Long generateSessionId() {
        return System.currentTimeMillis();
    }
}
