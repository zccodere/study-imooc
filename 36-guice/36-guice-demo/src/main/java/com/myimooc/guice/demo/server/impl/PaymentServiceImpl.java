package com.myimooc.guice.demo.server.impl;

import com.myimooc.guice.demo.server.PaymentService;

/**
 * 支付业务实现类；模拟订单系统
 *
 * @author zc 2017-10-15
 */
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void pay(long orderId, long price, Long sessionId) {
    }
}
