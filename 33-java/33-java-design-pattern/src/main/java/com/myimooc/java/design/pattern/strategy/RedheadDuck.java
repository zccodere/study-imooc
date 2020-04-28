package com.myimooc.java.design.pattern.strategy;

import com.myimooc.java.design.pattern.strategy.impl.FlyWithWin;

/**
 * 策略模式；红色头的鸭子
 *
 * @author zc 2017-08-31
 */
public class RedheadDuck extends AbstractDuck {

    public RedheadDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的");
    }
}
