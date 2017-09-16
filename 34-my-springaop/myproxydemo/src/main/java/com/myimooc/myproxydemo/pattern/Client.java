package com.myimooc.myproxydemo.pattern;

/**
 * @title 客户端
 * @describe 测试代理模式
 * @author zc
 * @version 1.0 2017-09-13
 */
public class Client {

	public static void main(String[] args) {
		Subject subject = new Proxy(new RealSubject());
		subject.request();
	}

}
