package com.myimooc.spring.aop.proxy.cglib;

import com.myimooc.spring.aop.proxy.pattern.RealSubject;
import com.myimooc.spring.aop.proxy.pattern.Subject;

import net.sf.cglib.proxy.Enhancer;

/**
 * 动态代理类；Cglib实现动态代理测试类
 *
 * @author zc 2017-09-13
 */
public class Client {

    public static void main(String[] args) {
        // 实例化Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置需要代理的对象
        enhancer.setSuperclass(RealSubject.class);
        // 设置需要植入的代码
        enhancer.setCallback(new DemoMethodInterceptor());
        // 生成代理类
        Subject subject = (Subject) enhancer.create();
        subject.request();
    }
}
