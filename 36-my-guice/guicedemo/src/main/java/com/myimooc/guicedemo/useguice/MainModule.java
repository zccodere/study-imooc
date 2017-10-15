package com.myimooc.guicedemo.useguice;

import com.google.inject.AbstractModule;
import com.myimooc.guicedemo.useguice.helloworlddemo.HelloWorldModule;

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
	}
}
