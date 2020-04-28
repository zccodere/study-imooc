package com.myimooc.spring.simple.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 方法执行前拦截
 *
 * @author zc 2017-01-18
 */
public class MockBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("MockBeforeAdvice : " + method.getName() + "     " + target.getClass().getName());
    }

}
