package com.myimooc.spring.simple.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: Mooc切面<br>
 * 描述: Mooc切面<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Component
@Aspect
public class MoocAspect {

    @Pointcut("execution(* com.myimooc.spring.simple.aop.aspectj.biz.*Biz.*(..))")
    public void pointcut() {
    }

    @Pointcut("within(com.myimooc.spring.simple.aop.aspectj.biz.*)")
    public void bizPointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("Before.");
    }

    @Before("pointcut() && args(arg)")
    public void beforeWithParam(String arg) {
        System.out.println("BeforeWithParam." + arg);
    }

    @Before("pointcut() && @annotation(moocMethod)")
    public void beforeWithAnnotaion(MoocMethod moocMethod) {
        System.out.println("BeforeWithAnnotation." + moocMethod.value());
    }

    @AfterReturning(pointcut = "bizPointcut()", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("AfterReturning : " + returnValue);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(RuntimeException e) {
        System.out.println("AfterThrowing : " + e.getMessage());
    }

    @After("pointcut()")
    public void after() {
        System.out.println("After.");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around 1.");
        Object obj = pjp.proceed();
        System.out.println("Around 2.");
        System.out.println("Around : " + obj);
        return obj;
    }

}
