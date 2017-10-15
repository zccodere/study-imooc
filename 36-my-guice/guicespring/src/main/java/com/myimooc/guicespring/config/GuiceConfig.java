package com.myimooc.guicespring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.myimooc.guicespring.service.MyApplet;
import com.myimooc.guicespring.service.greeting.GreetingHandler;
import com.myimooc.guicespring.service.greeting.HelloWorldWebModule;
import com.myimooc.guicespring.service.greeting.RequestParams;
import com.myimooc.guicespring.service.impl.WebDestination;

/**
 * @title 配置类
 * @describe Guice与SpringBoot协作
 * @author zc
 * @version 1.0 2017-10-15
 */
@Configuration
public class GuiceConfig {
	
	@Bean
	public Injector Injector(ApplicationContext context){
		return Guice.createInjector(
				new HelloWorldWebModule(),
				new SpringAwareServletModule(context));
	}

	@Bean
	@RequestScope
	public MyApplet applet(Injector Injector) {
		return Injector.getInstance(MyApplet.class);
	}

	@Bean
	@RequestScope
	public WebDestination destination(Injector Injector) {
		return Injector.getInstance(WebDestination.class);
	}
	
	@Bean
	@RequestScope
	public GreetingHandler greetingHandler(Injector Injector){
		return Injector.getInstance(GreetingHandler.class);
	}
	
	@Bean
	@RequestScope
	public RequestParams params(Injector Injector) {
		return Injector.getInstance(RequestParams.class);
	}

}
