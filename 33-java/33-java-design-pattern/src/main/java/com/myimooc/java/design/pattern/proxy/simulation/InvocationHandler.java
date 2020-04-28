package com.myimooc.java.design.pattern.proxy.simulation;

import java.lang.reflect.Method;

/**
 * 模拟JDK动态代理-业务处理类
 *
 * @author zc 2017-08-28
 */
public interface InvocationHandler {

    /**
     * 执行方法
     *
     * @param object object
     * @param method method
     */
    void invoke(Object object, Method method);

}
