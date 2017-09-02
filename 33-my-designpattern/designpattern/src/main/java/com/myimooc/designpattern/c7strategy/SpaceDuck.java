package com.myimooc.designpattern.c7strategy;

import com.myimooc.designpattern.c7strategy.impl.FlyWithRocket;

/**
 * @title 策略模式
 * @describe 太空鸭
 * @author zc
 * @version 1.0 2017-08-31
 */
public class SpaceDuck extends Duck {

	public SpaceDuck() {
		super();
		super.setFlyingStrategy(new FlyWithRocket());
	}
	
	@Override
	public void display() {
		System.out.println("我头戴宇航盔");
	}
	
	@Override
	public void quack() {
		System.out.println("我通过无线电与你通信");
	}

}
