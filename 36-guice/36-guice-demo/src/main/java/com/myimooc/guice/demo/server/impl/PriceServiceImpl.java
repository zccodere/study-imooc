package com.myimooc.guice.demo.server.impl;

import com.myimooc.guice.demo.server.PriceService;

/**
 * @title 价格业务实现类
 * @describe 模拟订单系统
 * @author zc
 * @version 1.0 2017-10-15
 */
public class PriceServiceImpl implements PriceService {

	@Override
	public long getPrice(long orderId) {
		return 456L;
	}

}
