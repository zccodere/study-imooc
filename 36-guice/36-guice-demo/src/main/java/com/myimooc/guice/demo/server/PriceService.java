package com.myimooc.guice.demo.server;

/**
 * 价格接口类；模拟订单系统
 *
 * @author zc 2017-10-15
 */
public interface PriceService {

    /**
     * 获取价格
     *
     * @param orderId 订单ID
     * @return 价格
     */
    long getPrice(long orderId);

}
