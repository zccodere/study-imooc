package com.myimooc.spring.simple.aop.schema.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Mock 切面
 *
 * @author zc 2017-01-18
 */
public class MockAspect {

    public void before() {
        System.out.println("MockAspect before.");
    }

    public void afterReturning() {
        System.out.println("MockAspect afterReturning.");
    }

    public void afterThrowing() {
        System.out.println("MockAspect afterThrowing.");
    }

    public void after() {
        System.out.println("MockAspect after.");
    }

    public Object around(ProceedingJoinPoint pjp) {
        Object obj = null;
        try {
            System.out.println("MockAspect around 1.");
            obj = pjp.proceed();
            System.out.println("MockAspect around 2.");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }

    public Object aroundInit(ProceedingJoinPoint pjp, String bizName, int times) {
        System.out.println(bizName + "   " + times);
        Object obj = null;
        try {
            System.out.println("MockAspect aroundInit 1.");
            obj = pjp.proceed();
            System.out.println("MockAspect aroundInit 2.");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }

}
