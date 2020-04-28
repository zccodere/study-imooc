package com.myimooc.java.design.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 对时间上的处理-使用JDK动态代理
 *
 * @author zc 2017-08-28
 */
public class TimeHandler implements InvocationHandler {

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    private Object target;

    /**
     * 参数： proxy 被代理对象 method 被代理对象方法 args 方法的参数 返回值： Object 方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");

        method.invoke(target);

        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...汽车行驶时间：" + (endTime - startTime) + "毫秒");

        return null;
    }

}
