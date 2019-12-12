package com.myimooc.spring.simple.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * <br>
 * 标题: 正常返回拦截<br>
 * 描述: 正常返回拦截<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable {
        System.out.println("MoocAfterReturningAdvice : " + method.getName() + "     " +
                target.getClass().getName() + "       " + returnValue);
    }

}
