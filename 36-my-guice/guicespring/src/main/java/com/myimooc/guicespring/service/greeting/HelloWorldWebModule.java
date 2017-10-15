package com.myimooc.guicespring.service.greeting;

import com.google.inject.AbstractModule;
import com.myimooc.guicespring.service.MyApplet;
import com.myimooc.guicespring.service.MyDestination;
import com.myimooc.guicespring.service.Output;
import com.myimooc.guicespring.service.impl.StringWritingApplet;
import com.myimooc.guicespring.service.impl.WebDestination;

/**
 * @title Module配置类
 * @describe Hello模块相关依赖配置
 * @author zc
 * @version 1.0 2017-10-15
 */
public class HelloWorldWebModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MyApplet.class).to(StringWritingApplet.class);
		bind(MyDestination.class).to(WebDestination.class);
		bind(String.class)
			.annotatedWith(Output.class)
			.toProvider(GreetingMessageProvider.class);
	}
}
