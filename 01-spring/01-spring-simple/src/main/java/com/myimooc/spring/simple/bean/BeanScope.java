package com.myimooc.spring.simple.bean;

/**
 * Bean作用域
 *
 * @author zc 2017-01-18
 */
public class BeanScope {

    public void say() {
        System.out.println("BeanScope say : " + this.hashCode());
    }

}
