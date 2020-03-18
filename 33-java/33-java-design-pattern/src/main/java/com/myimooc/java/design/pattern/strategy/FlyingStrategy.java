package com.myimooc.java.design.pattern.strategy;

/**
 * 策略模式；策略接口，实现鸭子的飞行行为
 *
 * @author zc 2017-08-31
 */
public interface FlyingStrategy {

    /**
     * 飞行行为的方法
     */
    void performFly();

}
