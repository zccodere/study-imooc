package com.myimooc.guice.demo.server;

/**
 * 付款接口类；模拟订单系统
 *
 * @author zc 2017-10-15
 */
public interface PaymentService {

    /**
     * 支付
     *
     * @param orderId   订单ID
     * @param price     价格
     * @param sessionId 会话ID
     */
    void pay(long orderId, long price, Long sessionId);

}
