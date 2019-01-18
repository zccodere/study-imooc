package com.imooc.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.imooc.spring.aop.aspectj.MoocMethod;

@Component
@Aspect
public class MoocAspect {
	
	@Pointcut("execution(* com.imooc.aop.aspectj.biz.*Biz.*(..))")
	public void pointcut() {}
	
	@Pointcut("within(com.imooc.aop.aspectj.biz.*)")
	public void bizPointcut() {}
	
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
	
	@AfterReturning(pointcut="bizPointcut()", returning="returnValue")
	public void afterReturning(Object returnValue) {
		System.out.println("AfterReturning : " + returnValue);
	}
	
	@AfterThrowing(pointcut="pointcut()", throwing="e")
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
