package org.demo.guicedemo.server.impl;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

public class CacheTest {
	@Inject PaymentServiceImpl paymentService;
	@Inject PriceServiceImpl priceService;

	@Before public void setUp() {
		Guice.createInjector(new ServerModule())
				.injectMembers(this);
	}

	@Test
	public void testCache() {
		paymentService.putCache("testKey", "testValue");
		String cachedValue =
				priceService.getCachedValue("testKey");
		assertEquals("testValue", cachedValue);
	}

}
