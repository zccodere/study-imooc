package com.myimooc.java.design.pattern.strategy;


import com.myimooc.java.design.pattern.strategy.impl.FlyWithWin;

/**
 * 策略模式；绿脖子的鸭子
 *
 * @author zc 2017-08-31
 */
public class MallardDuck extends AbstractDuck {

    public MallardDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }
}
