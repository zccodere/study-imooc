package com.myimooc.designpattern.c3proxy.car;


/**
 * @describe 测试类
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Client {
	
	public static void main(String[] args) {
//		test1();
		test2();
		
	}
	
	// 2-2 聚合与继承 代理功能叠加测试方法
	public static void test2(){
		Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();
	}
	
	// 2-1 静态代理测试方法
	public static void test1(){
//		Car car = new Car();
//		car.move();
		
		// 使用继承的方式
//		Moveable m = new Car2();
//		m.move();
		
		// 使用聚合方式
		Car car = new Car();
		Moveable m = new Car3(car);
		m.move();
	}
	
}
