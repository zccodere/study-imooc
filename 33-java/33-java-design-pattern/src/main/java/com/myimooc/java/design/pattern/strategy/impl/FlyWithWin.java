package com.myimooc.java.design.pattern.strategy.impl;


import com.myimooc.java.design.pattern.strategy.FlyingStrategy;

/**
 * 策略模式；实现鸭子的飞行行为，用翅膀飞行的类
 *
 * @author zc 2017-08-31
 */
public class FlyWithWin implements FlyingStrategy {

    @Override
    public void performFly() {
        System.out.println("振翅高飞");
    }
}
