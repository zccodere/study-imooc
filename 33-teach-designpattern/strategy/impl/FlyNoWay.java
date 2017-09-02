package com.imooc.pattern.strategy.impl;

import com.imooc.pattern.strategy.FlyingStragety;

public class FlyNoWay implements FlyingStragety {

	public void performFly() {
		System.out.println("我不会飞行！");
	}

}
