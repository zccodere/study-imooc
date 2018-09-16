package com.myimooc.spring.simple.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * <br>
 * 标题: 方法执行前拦截<br>
 * 描述: 方法执行前拦截<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("MoocBeforeAdvice : " + method.getName() + "     " +
                target.getClass().getName());
    }

}
