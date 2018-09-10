package com.myimooc.java.design.pattern.strategy;

import com.myimooc.java.design.pattern.strategy.impl.FlyNoWay;

/**
 * @title 策略模式
 * @describe 大黄鸭
 * @author zc
 * @version 1.0 2017-08-31
 */
public class BigYellowDuck extends AbstractDuck {
	
	public BigYellowDuck() {
		super();
		super.setFlyingStrategy(new FlyNoWay());
	}
	
	@Override
	public void display() {
		System.out.println("我身体很大，全身黄黄");
	}
}

