package com.myimooc.java.design.pattern.strategy;

/**
 * 策略模式；测试类
 *
 * @author zc 2017-08-31
 * @version 1.0 2017-08-31
 */
public class DuckMain {

    public static void main(String[] args) {
        System.out.println("测试鸭子程序");
        System.out.println("*************************");

        AbstractDuck duck = null;
//		duck = new MallardDuck();
//		duck = new RedheadDuck();
//		duck = new RubberDuck();
//		duck = new BigYellowDuck();
        duck = new SpaceDuck();

        duck.display();
        duck.quack();
        duck.fly();

        System.out.println("*************************");
        System.out.println("测试程序完毕");
    }

}
