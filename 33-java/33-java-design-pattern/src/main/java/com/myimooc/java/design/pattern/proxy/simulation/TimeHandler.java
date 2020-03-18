package com.myimooc.java.design.pattern.proxy.simulation;

import java.lang.reflect.Method;

/**
 * 模拟JDK动态代理-时间业务逻辑处理
 *
 * @author zc 2017-08-28
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object object, Method method) {
        try {

            long startTime = System.currentTimeMillis();
            System.out.println("汽车开始行驶...");

            method.invoke(target);

            long endTime = System.currentTimeMillis();
            System.out.println("汽车结束行驶...汽车行驶时间：" + (endTime - startTime) + "毫秒");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
