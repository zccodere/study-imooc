package org.demo.guicedemo.server.impl;

import javax.inject.Inject;

import org.demo.guicedemo.Logged;
import org.demo.guicedemo.server.PaymentService;

import com.google.common.cache.Cache;

public class PaymentServiceImpl implements PaymentService {
	private final Cache<String, String> cache;

	@Inject
	public PaymentServiceImpl(Cache<String, String> cache) {
		super();
		this.cache = cache;
	}

	@Override @Logged
	public void pay(long orderId, long price, Long sessionId) {
		// TODO Auto-generated method stub
	}

	void putCache(String key, String value) {
		cache.put(key, value);
	}
}
