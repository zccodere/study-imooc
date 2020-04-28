package com.myimooc.java.design.pattern.strategy;

import com.myimooc.java.design.pattern.strategy.impl.FlyNoWay;

/**
 * 策略模式；大黄鸭
 *
 * @author zc 2017-08-31
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

