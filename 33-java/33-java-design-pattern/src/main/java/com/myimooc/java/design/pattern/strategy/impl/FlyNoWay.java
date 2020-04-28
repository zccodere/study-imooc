package com.myimooc.java.design.pattern.strategy.impl;


import com.myimooc.java.design.pattern.strategy.FlyingStrategy;

/**
 * 策略模式；实现鸭子的飞行行为，不会飞行的策略类
 *
 * @author zc 2017-08-31
 */
public class FlyNoWay implements FlyingStrategy {

    @Override
    public void performFly() {
        System.out.println("我不会飞行！");
    }

}
