package com.myimooc.spring.simple.beanannotation.javabased;

/**
 * 字符串仓库
 *
 * @author zc 2017-01-18
 */
public class StringStore implements Store<String> {

    public void init() {
        System.out.println("This is init.");
    }

    public void destroy() {
        System.out.println("This is destroy.");
    }

}
