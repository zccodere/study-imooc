package com.myimooc.spring.simple.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <br>
 * 标题: 环绕拦截<br>
 * 描述: 环绕拦截<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MoocMethodInterceptor 1 : " + invocation.getMethod().getName() + "     " +
                invocation.getStaticPart().getClass().getName());
        Object obj = invocation.proceed();
        System.out.println("MoocMethodInterceptor 2 : " + obj);
        return obj;
    }

}
