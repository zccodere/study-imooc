package com.myimooc.java.design.pattern.strategy;

/**
 * 策略模式；超类，所有的鸭子都要继承此类，抽象了鸭子的行为：显示和鸣叫
 *
 * @author zc 2017-08-31
 */
public abstract class AbstractDuck {

    /**
     * 鸭子发出叫声，通用行为，由超类实现
     */
    public void quack() {
        System.out.println("嘎嘎嘎");
    }

    /**
     * 显示鸭子的外观，鸭子的外观各不相同，声明为abstract，由子类实现
     */
    public abstract void display();

    /**
     * 组合进飞行的策略接口
     */
    private FlyingStrategy flyingStrategy;

    public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }

    /**
     * 鸭子的飞行功能
     */
    public void fly() {
        // 由飞行策略接口执行飞行的动作
        flyingStrategy.performFly();
    }
}
