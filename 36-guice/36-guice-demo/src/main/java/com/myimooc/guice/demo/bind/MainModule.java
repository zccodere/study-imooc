package com.myimooc.guice.demo.bind;

import com.google.inject.AbstractModule;
import com.myimooc.guice.demo.bind.helloworlddemo.HelloWorldModule;
import com.myimooc.guice.demo.bind.helloworlddemo.PrintLineModule;

/**
 * @title MainModule类
 * @describe Guice用来配置的类
 * @author zc
 * @version 1.0 2017-10-15
 */
public class MainModule extends AbstractModule{
	
	@Override
	protected void configure() {
		install(new HelloWorldModule());
		install(new PrintLineModule());
	}
}
