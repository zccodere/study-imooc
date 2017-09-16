package com.myimooc.myproxydemo.cglib;

import com.myimooc.myproxydemo.pattern.RealSubject;
import com.myimooc.myproxydemo.pattern.Subject;

import net.sf.cglib.proxy.Enhancer;

/**
 * @title 动态代理类
 * @describe Cglib实现动态代理测试类
 * @author zc
 * @version 1.0 2017-09-13
 */
public class Client {
	
	public static void main(String[] args) {
		// 实例化Enhancer对象
		Enhancer enhancer = new Enhancer();
		// 设置需要代理的对象
		enhancer.setSuperclass(RealSubject.class);
		// 设置需要植入的代码
		enhancer.setCallback(new DemoMethodInterceptor());
		// 生成代理类
		Subject subject = (Subject)enhancer.create();
		subject.request();
	}
}
