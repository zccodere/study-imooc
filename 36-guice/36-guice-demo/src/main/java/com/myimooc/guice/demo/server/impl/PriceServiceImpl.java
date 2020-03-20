package com.myimooc.guice.demo.server.impl;

import com.myimooc.guice.demo.server.PriceService;

/**
 * 价格业务实现类；模拟订单系统
 *
 * @author zc 2017-10-15
 */
public class PriceServiceImpl implements PriceService {

    @Override
    public long getPrice(long orderId) {
        return 456L;
    }

}
