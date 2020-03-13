package com.myimooc.spring.simple.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕拦截
 *
 * @author zc 2017-01-18
 */
public class MockMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MockMethodInterceptor 1 : " + invocation.getMethod().getName() + "     " + invocation.getStaticPart().getClass().getName());
        Object obj = invocation.proceed();
        System.out.println("MockMethodInterceptor 2 : " + obj);
        return obj;
    }

}
