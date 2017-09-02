package com.myimooc.designpattern.c3proxy.simulationjdk;

import com.myimooc.designpattern.c3proxy.car.Car;
import com.myimooc.designpattern.c3proxy.car.Moveable;

/**
 * @describe 模拟JDK动态代理-测试类
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Client {
	
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
		m.move();
	}
}
