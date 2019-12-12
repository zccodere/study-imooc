package com.myimooc.java.design.pattern.proxy.simulation;


import com.myimooc.java.design.pattern.proxy.car.Car;
import com.myimooc.java.design.pattern.proxy.car.MoveAble;

/**
 * @describe 模拟JDK动态代理-测试类
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Client {
	
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		MoveAble m = (MoveAble)Proxy.newProxyInstance(MoveAble.class,h);
		m.move();
	}
}
