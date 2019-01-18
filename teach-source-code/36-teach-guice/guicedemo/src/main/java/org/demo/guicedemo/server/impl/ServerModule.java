package org.demo.guicedemo.server.impl;

import org.demo.guicedemo.Logged;
import org.demo.guicedemo.server.OrderService;
import org.demo.guicedemo.server.PaymentService;
import org.demo.guicedemo.server.PriceService;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ChinaModule());
		install(new GlobalModule());

		bind(OrderService.class).to(OrderServiceImpl.class);
		bind(PaymentService.class).to(PaymentServiceImpl.class);
		bind(PriceService.class).to(PriceServiceImpl.class);

		bind(new TypeLiteral<Cache<String, String>>(){})
			.to(GuiceDemoCache.class);

		LoggingInterceptor loggingInterceptor =
				new LoggingInterceptor();
		requestInjection(loggingInterceptor);
		bindInterceptor(Matchers.any(),
				Matchers.annotatedWith(Logged.class),
				loggingInterceptor);
	}

	@Provides @SessionId Long generateSesssionId() {
		return System.currentTimeMillis();
	}
}
