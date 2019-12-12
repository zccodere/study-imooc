package com.myimooc.guice.demo.server.impl;

import javax.inject.Inject;

import com.myimooc.guice.demo.server.OrderService;
import com.myimooc.guice.demo.server.PaymentService;
import com.myimooc.guice.demo.server.PriceService;

/**
 * @author zc
 * @version 1.0 2017-10-15
 * @title 订单业务实现类
 * @describe 模拟订单系统
 */
public class OrderServiceImpl implements OrderService {
    /**
     * 表示类的依赖，需要加上final
     */
    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManager sessionManager;
	
    /**
     * 表示类的状态，不用加上final
     */
    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManager sessionManager) {
        super();
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }

    @Override
    public void sendToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price, sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;

        System.out.println("订购成功：Price=" + price + " SessionId=" + sessionManager.getSessionId()
                + " ordersPaid=" + ordersPaid);
    }
}
