package com.myimooc.java.design.pattern.proxy.car;

/**
 * @describe 聚合的方式实现静态代理
 * @author zc
 * @version 1.0 2017-08-28
 */
public class Car3 implements MoveAble {
	
	public Car3(Car car) {
		super();
		this.car = car;
	}

	private Car car;
	
	@Override
	public void move() {
		
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		
		car.move();
		
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶...汽车行驶时间："+(endtime - starttime) + "毫秒");
		
	}

}
