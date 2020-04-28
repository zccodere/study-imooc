package com.myimooc.spring.simple.aop.api;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 异常拦截
 *
 * @author zc 2017-01-18
 */
public class MockThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) {
        System.out.println("MockThrowsAdvice afterThrowing 1");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("MockThrowsAdvice afterThrowing 2 : " + method.getName() + " # " + target.getClass().getName());
    }

}
