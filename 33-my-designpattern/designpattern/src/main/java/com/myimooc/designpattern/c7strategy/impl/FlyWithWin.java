package com.myimooc.designpattern.c7strategy.impl;

import com.myimooc.designpattern.c7strategy.FlyingStrategy;

/**
 * @title 策略模式
 * @describe 实现鸭子的飞行行为，用翅膀飞行的类
 * @author zc
 * @version 1.0 2017-08-31
 */
public class FlyWithWin implements FlyingStrategy{

	@Override
	public void performFly() {
		System.out.println("振翅高飞");
	}
}
