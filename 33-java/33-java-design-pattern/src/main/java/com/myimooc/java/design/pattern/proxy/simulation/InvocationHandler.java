package com.myimooc.java.design.pattern.proxy.simulation;

import java.lang.reflect.Method;

/**
 * @author zc
 * @version 1.0 2017-08-28
 * @describe 模拟JDK动态代理-业务处理类
 */
public interface InvocationHandler {

    /**
     * 执行
     *
     * @param obj    object
     * @param method method
     */
    void invoke(Object obj, Method method);

}
