package com.myimooc.java.design.pattern.proxy.car;

/**
 * 汽车日志功能的代理
 *
 * @author zc 2017-08-28
 */
public class CarLogProxy implements MoveAble {

    /**
     * 因为代理类和被代理类都是实现相同的接口，所以构造方法传递的对象也可以是 MoveAble对象
     *
     * @param m MoveAble
     */
    public CarLogProxy(MoveAble m) {
        super();
        this.m = m;
    }

    private MoveAble m;

    @Override
    public void move() {
        System.out.println("日志开始");
        m.move();
        System.out.println("日志结束");
    }
}
