package com.myimooc.guice.spring.service.greeting;

import com.google.inject.AbstractModule;

import com.myimooc.guice.spring.service.MyApplet;
import com.myimooc.guice.spring.service.MyDestination;
import com.myimooc.guice.spring.service.Output;
import com.myimooc.guice.spring.service.impl.StringWritingApplet;
import com.myimooc.guice.spring.service.impl.WebDestination;

/**
 * Hello模块相关依赖配置
 *
 * @author zc 2017-10-15
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
