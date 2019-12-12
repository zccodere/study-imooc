package com.myimooc.java.design.pattern.proxy.jdk;

import com.myimooc.java.design.pattern.proxy.car.Car;
import com.myimooc.java.design.pattern.proxy.car.MoveAble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @describe JDK动态代理测试类
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Test {
	
	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		
		// 使用Proxy类newProxyInstance方法动态创建代理类
		/**
		 * loader 类加载器
		 * interfaces 实现接口
		 * h InvocationHandler
		 */
		MoveAble m = (MoveAble)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		
		m.move();
		
	}
	
}
