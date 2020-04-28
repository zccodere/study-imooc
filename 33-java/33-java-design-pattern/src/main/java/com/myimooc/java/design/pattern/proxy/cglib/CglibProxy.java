package com.myimooc.java.design.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 *
 * @author zc 2017-08-28
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhance = new Enhancer();

    public Object getProxy(Class targetClass) {
        // 设置创建子类的类
        enhance.setSuperclass(targetClass);
        enhance.setCallback(this);
        return enhance.create();
    }

    /**
     * 拦截所有目标类方法的调用 参数： obj 目标类的实例 method 目标方法的反射对象 args 方法的参数 proxy 代理类的实例
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("日志开始...");

        // 代理类调用父类的方法
        proxy.invokeSuper(obj, args);

        System.out.println("日志结束...");

        return null;
    }

}
