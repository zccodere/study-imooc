package com.imooc.pattern;

/**
 * Created by cat on 2017-02-27.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real subject execute request");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
