package com.myimooc.spring.simple.beanannotation.javabased;

/**
 * <br>
 * 标题: 驱动管理<br>
 * 描述: 驱动管理<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MyDriverManager {

    public MyDriverManager(String url, String userName, String password) {
        System.out.println("url : " + url);
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
    }

}
