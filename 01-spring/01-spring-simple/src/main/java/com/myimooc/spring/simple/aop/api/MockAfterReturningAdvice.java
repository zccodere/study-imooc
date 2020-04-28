package com.myimooc.spring.simple.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 正常返回拦截
 *
 * @author zc 2017-01-18
 */
public class MockAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MockAfterReturningAdvice : " + method.getName() + " ## " + target.getClass().getName() + "       " + returnValue);
    }

}
