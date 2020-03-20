package com.myimooc.guice.demo.bind;

import com.google.inject.AbstractModule;

import com.myimooc.guice.demo.bind.helloworlddemo.HelloWorldModule;
import com.myimooc.guice.demo.bind.helloworlddemo.PrintLineModule;

/**
 * Guice用来配置的类
 *
 * @author zc 2017-10-15
 */
public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
        install(new PrintLineModule());
    }
}
