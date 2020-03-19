package com.myimooc.spring.aop.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 需要植入的代码类；需要实现 MethodInterceptor 接口
 *
 * @author zc 2017-09-13
 */
public class DemoMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before in cglib");

        Object result;
        try {
            // 代理类调用父类的方法
            result = proxy.invokeSuper(obj, args);
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            // 在目标对象方法执行之后做一些额外的事情
            System.out.println("after in cglib");
        }
        return result;
    }
}
