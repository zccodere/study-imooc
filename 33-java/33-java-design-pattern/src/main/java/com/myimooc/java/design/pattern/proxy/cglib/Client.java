package com.myimooc.java.design.pattern.proxy.cglib;


/**
 * @describe cglib代理测试类
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Client {
	
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		Train t = (Train)proxy.getProxy(Train.class);
		t.move();
	}
}
