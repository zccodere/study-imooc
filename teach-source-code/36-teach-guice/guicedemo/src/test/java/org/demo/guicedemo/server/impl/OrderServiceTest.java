package org.demo.guicedemo.server.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import javax.inject.Inject;

import org.demo.guicedemo.server.OrderService;
import org.demo.guicedemo.server.PriceService;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.util.Modules;

class PriceServiceMock extends PriceServiceImpl {

	@Inject
	public PriceServiceMock(Set<String> supportedCurrencies) {
		super(supportedCurrencies, null);
	}

	@Override
	public long getPrice(long orderId) {
		return 567L;
	}
}

public class OrderServiceTest {
	@Inject private OrderService orderService;
	@Inject private PriceService priceService;

	@Before public void setUp() {
		Guice.createInjector(Modules.override(new ServerModule())
				.with(new AbstractModule() {
					@Override
					protected void configure() {
						bind(PriceService.class)
							.to(PriceServiceMock.class);
					}
				}))
			.injectMembers(this);
	}

	@Test
	public void testSendToPayment() {
		try {
			orderService.sendToPayment(789L);
			fail("Exception expected.");
		} catch (RuntimeException e) {
			assertTrue(e.getMessage().contains("Price=567"));
			assertTrue(e.getMessage().contains("OrdersPaid=1"));
		}
	}

	@Test
	public void testSupportedCurrencies() {
		assertEquals("[CNY, EUR, USD]",
				priceService.getSupportedCurrencies()
					.toString());
	}
}
