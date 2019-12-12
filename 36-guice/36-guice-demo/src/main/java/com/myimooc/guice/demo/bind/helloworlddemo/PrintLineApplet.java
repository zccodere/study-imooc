package com.myimooc.guice.demo.bind.helloworlddemo;

import com.myimooc.guice.demo.bind.MyApplet;

/**
 * @title PrintLineApplet类
 * @describe 打印当前类名
 * @author zc
 * @version 1.0 2017-10-15
 */
public class PrintLineApplet implements MyApplet {

	@Override
	public void run() {
		System.out.println("printLineApplet");
	}

}
