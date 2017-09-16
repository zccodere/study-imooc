package com.myimooc.myproxydemo.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @title 需要植入的代码类
 * @describe 需要实现MethodInterceptorj接口
 * @author zc
 * @version 1.0 2017-09-13
 */
public class DemoMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("before in cglib");
		
		Object result = null;
		try{
			// 代理类调用父类的方法
			proxy.invokeSuper(obj, args);
		}catch (Exception e) {
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally {
			// 在目标对象方法执行之后做一些额外的事情
			System.out.println("after in cglib");
		}
		return result;
	}
}
