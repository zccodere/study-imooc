package com.myimooc.guice.demo.bind.helloworlddemo;

import com.google.inject.AbstractModule;
import com.myimooc.guice.demo.bind.Applets;

/**
 * @title PrintLineModule类
 * @describe 绑定依赖
 * @author zc
 * @version 1.0 2017-10-15
 */
public class PrintLineModule extends AbstractModule {

	@Override
	protected void configure() {
		Applets.register(binder()).named("println").to(PrintLineApplet.class);
	}
}
