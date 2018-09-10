package com.myimooc.guice.demo.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.common.base.Joiner;

/**
 * @title LoggedMethodInterceptor类
 * @describe 切面类，用于处理被拦截的方法，实现日志记录
 * @author zc
 * @version 1.0 2017-10-15
 */
public class LoggedInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 获得调用参数
		invocation.getArguments();
		// 获得调用对象
		invocation.getClass();
		// 获得调用方法
		Method method = invocation.getMethod();
		
		// 记录日志
		System.out.println(String.format("Calling %s#%s(%s)",
			method.getDeclaringClass().getName(),
			method.getName(),
			Joiner.on(",").join(invocation.getArguments())));
		
		// 执行调用方法
		Object result = invocation.proceed();
		
		// 返回调用结果
		return result;
	}
}
