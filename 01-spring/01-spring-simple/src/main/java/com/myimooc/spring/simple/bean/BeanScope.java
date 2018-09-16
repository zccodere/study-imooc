package com.myimooc.spring.simple.bean;

/**
 * <br>
 * 标题: Bean作用域<br>
 * 描述: Bean作用域<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class BeanScope {

    public void say() {
        System.out.println("BeanScope say : " + this.hashCode());
    }

}
