package com.myimooc.guice.demo.server.impl;

import com.google.inject.Guice;

import com.myimooc.guice.demo.server.OrderService;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

/**
 * 模拟订单系统测试类
 *
 * @author zc 2017-10-15
 */
public class OrderServiceTest {

    @Inject
    private OrderService orderService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void TestSendToPayment() {
        orderService.sendToPayment(789L);
    }
}
