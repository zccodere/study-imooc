package com.myimooc.guicedemo.noguice;

import com.myimooc.guicedemo.noguice.helloworlddemo.PrintStreamWriter;
import com.myimooc.guicedemo.noguice.helloworlddemo.StringProvider;
import com.myimooc.guicedemo.noguice.helloworlddemo.StringWritingApplet;

/**
 * @title Configuration类
 * @describe 程序启动配置类
 * @author zc
 * @version 1.0 2017-10-15
 */
public class Configuration {
	
	public static MyApplet getMainApplet() {
		return new StringWritingApplet(
			   new PrintStreamWriter(System.out),
			   new StringProvider() {
					@Override
					public String get() {
						return "Hello World";
					}
				});
	}
}
