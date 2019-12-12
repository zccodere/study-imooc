package com.myimooc.java.design.pattern.proxy.car;

/**
 * @describe 继承的方式实现静态代理
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Car2 extends Car {

	@Override
	public void move() {
		
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		
		super.move();
		
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶...汽车行驶时间："+(endtime - starttime) + "毫秒");
		
	}
}
