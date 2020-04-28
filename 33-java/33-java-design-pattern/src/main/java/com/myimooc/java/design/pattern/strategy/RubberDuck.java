package com.myimooc.java.design.pattern.strategy;

import com.myimooc.java.design.pattern.strategy.impl.FlyNoWay;

/**
 * 策略模式；橡胶鸭
 *
 * @author zc 2017-08-31
 */
public class RubberDuck extends AbstractDuck {

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
