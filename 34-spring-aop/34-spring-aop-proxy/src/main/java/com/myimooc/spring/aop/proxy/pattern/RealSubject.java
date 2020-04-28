package com.myimooc.spring.aop.proxy.pattern;

/**
 * 目标对象；实现了Subject接口
 *
 * @author zc 2017-09-13
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real subject execute request");
    }

}
