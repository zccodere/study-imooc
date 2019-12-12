package com.myimooc.spring.simple.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * <br>
 * 标题: 异常拦截<br>
 * 描述: 异常拦截<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocThrowsAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("MoocThrowsAdvice afterThrowing 1");
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
		System.out.println("MoocThrowsAdvice afterThrowing 2 : " + method.getName() + "       " + 
				target.getClass().getName());
	}

}
