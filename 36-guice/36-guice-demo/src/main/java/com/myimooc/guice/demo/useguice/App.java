package com.myimooc.guice.demo.useguice;

import com.google.inject.Guice;

/**
 * @title 启动类
 * @describe 改造HelloWorld类
 * @author zc
 * @version 1.0 2017-10-15
 */
public class App {
	/**
	 * main方法的作用
	 * bootstrap:
	 *   parse command line：解析命令行参数
	 *   set up environment：配置环境参数
	 *   kick off main logic：启动程序逻辑
	 * @param args
	 */
	public static void main(String[] args) {
		MyApplet mainApplet = Guice
				.createInjector(new MainModule())
				.getInstance(MyApplet.class);
		mainApplet.run();
	}
}
