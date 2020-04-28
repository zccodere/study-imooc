package com.myimooc.spring.aop.guide.security;

/**
 * 获取用户信息；模拟用户的切换，将用户信息存入当前线程
 *
 * @author zc 2017-09-03
 */
public class CurrentUserHolder {

    private static final String UNKNOWN = "unknown";

    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static String get() {
        return HOLDER.get() == null ? UNKNOWN : HOLDER.get();
    }

    public static void set(String user) {
        HOLDER.set(user);
    }

    public static void remove() {
        HOLDER.remove();
    }
}
