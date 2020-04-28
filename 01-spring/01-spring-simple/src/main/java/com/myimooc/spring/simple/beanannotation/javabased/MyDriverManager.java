package com.myimooc.spring.simple.beanannotation.javabased;

/**
 * 驱动管理
 *
 * @author zc 2017-01-18
 */
public class MyDriverManager {

    public MyDriverManager(String url, String userName, String password) {
        System.out.println("url : " + url);
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
    }

}
