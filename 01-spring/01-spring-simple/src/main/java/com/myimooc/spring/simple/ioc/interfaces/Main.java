package com.myimooc.spring.simple.ioc.interfaces;

/**
 * <br>
 * 标题: 测试类<br>
 * 描述: 面向接口编程测试类<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class Main {

    public static void main(String[] args) {
        OneInterface oneInterface = new OneInterfacesImpl();
        System.out.println(((OneInterfacesImpl) oneInterface).hello("word"));
    }
}
