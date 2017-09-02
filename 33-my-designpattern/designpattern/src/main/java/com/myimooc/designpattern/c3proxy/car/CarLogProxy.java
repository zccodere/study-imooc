package com.myimooc.designpattern.c3proxy.car;

/**
 * @describe 汽车日志功能的代理
 * @author zc
 * @version 1.0 2017-08-28
 */
public class CarLogProxy implements Moveable {
	
	// 因为代理类和被代理类都是实现相同的接口，所以构造方法传递的对象也可以是Moveable对象
	public CarLogProxy(Moveable m) {
		super();
		this.m = m;
	}
	private Moveable m;
	
	@Override
	public void move() {
		System.out.println("日志开始");
		m.move();
		System.out.println("日志结束");
	}
}
