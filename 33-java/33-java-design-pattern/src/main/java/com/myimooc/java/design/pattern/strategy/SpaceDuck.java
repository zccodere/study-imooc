package com.myimooc.java.design.pattern.strategy;

import com.myimooc.java.design.pattern.strategy.impl.FlyWithRocket;

/**
 * 策略模式；太空鸭
 *
 * @author zc 2017-08-31
 */
public class SpaceDuck extends AbstractDuck {

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
