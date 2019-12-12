package com.myimooc.spring.aop.guide.security;

/**
 * @author zc
 * @version 1.0 2017-09-03
 * @title 获取用户信息
 * @describe 模拟用户的切换，将用户信息存入当前线程
 */
public class CurrentUserHolder {

    private static final String UNKOWN = "unkown";

    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static String get() {
        return HOLDER.get() == null ? UNKOWN : HOLDER.get();
    }

    public static void set(String user) {
        HOLDER.set(user);
    }

    public static void remove(){
        HOLDER.remove();
    }
}
