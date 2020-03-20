package com.myimooc.guice.spring.config;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.myimooc.guice.spring.service.MyApplet;
import com.myimooc.guice.spring.service.greeting.GreetingHandler;
import com.myimooc.guice.spring.service.greeting.HelloWorldWebModule;
import com.myimooc.guice.spring.service.greeting.RequestParams;
import com.myimooc.guice.spring.service.impl.WebDestination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

/**
 * 配置类；Guice与SpringBoot协作
 *
 * @author zc 2017-10-15
 */
@Configuration
public class GuiceConfig {

    @Bean
    public Injector injector(ApplicationContext context) {
        return Guice.createInjector(
                new HelloWorldWebModule(),
                new SpringAwareServletModule(context));
    }

    @Bean
    @RequestScope
    public MyApplet applet(Injector injector) {
        return injector.getInstance(MyApplet.class);
    }

    @Bean
    @RequestScope
    public WebDestination destination(Injector injector) {
        return injector.getInstance(WebDestination.class);
    }

    @Bean
    @RequestScope
    public GreetingHandler greetingHandler(Injector injector) {
        return injector.getInstance(GreetingHandler.class);
    }

    @Bean
    @RequestScope
    public RequestParams params(Injector injector) {
        return injector.getInstance(RequestParams.class);
    }

}
