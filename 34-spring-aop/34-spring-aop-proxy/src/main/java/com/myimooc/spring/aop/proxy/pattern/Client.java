package com.myimooc.spring.aop.proxy.pattern;

/**
 * 客户端；测试代理模式
 *
 * @author zc 2017-09-13
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }

}
