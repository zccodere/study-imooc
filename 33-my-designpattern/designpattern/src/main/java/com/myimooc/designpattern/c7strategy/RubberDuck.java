package com.myimooc.designpattern.c7strategy;

import com.myimooc.designpattern.c7strategy.impl.FlyNoWay;

/**
 * @title 策略模式
 * @describe 橡胶鸭
 * @author zc
 * @version 1.0 2017-08-31
 */
public class RubberDuck extends Duck{
	
	public RubberDuck() {
		super();
		super.setFlyingStrategy(new FlyNoWay());
	}
	
	@Override
	public void display() {
		System.out.println("我全身发黄，嘴巴很红");
	}

	@Override
	public void quack() {
		System.out.println("嘎~嘎~嘎~");
	}
}
