package com.myimooc.spring.aop.proxy.jdkimpl;

import com.myimooc.spring.aop.proxy.pattern.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类；相当于AOP的aspect
 *
 * @author zc 2017-09-13
 */
public class JdkSubject implements InvocationHandler {

    /**
     * 同样需要引入目标对象
     */
    private RealSubject realSubject;

    public JdkSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在目标对象方法执行之前做一些额外的事情
        System.out.println("before");
        Object result;
        try {
            // 代理对象不会做真实的业务逻辑，还是委托给真实的目标对象执行
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            // 在目标对象方法执行之后做一些额外的事情
            System.out.println("after");
        }
        return result;
    }
}
