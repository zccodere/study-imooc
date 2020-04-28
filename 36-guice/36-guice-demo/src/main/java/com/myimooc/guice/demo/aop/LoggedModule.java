package com.myimooc.guice.demo.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * 用于配置依赖绑定
 *
 * @author zc 2017-10-15
 */
public class LoggedModule extends AbstractModule {

    @Override
    protected void configure() {

        // 配置拦截任意类，带有@Logged注解修饰的方法
        bindInterceptor(
                Matchers.any(),
                Matchers.annotatedWith(Logged.class),
                new LoggedInterceptor());

    }
}
