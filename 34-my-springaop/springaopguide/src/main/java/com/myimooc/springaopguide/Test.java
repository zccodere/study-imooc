package com.myimooc.springaopguide;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class Test {
	
	// 匹配AOP对象的目标对象为指定类型的方法，即DemoDao的aop代理对象的方法
	@Pointcut("this(com.myimooc.springaopguide.dao.DemoDao)")
	public void testDemo(){}
	
	// 匹配实现IDao接口的目标对象（而不是aop代理后的对象）的方法，这里即DemoDao的方法
	@Pointcut("target(com.myimooc.springaopguide.dao.IDao)")
	public void targetDemo(){}
	
	// 匹配所有以Service结尾的bean里面的方法
	@Pointcut("bean(*Service)")
	public void beanDemo(){}
	
	
	// 匹配任何以find开头而且只有一个Long参数的方法
	@Pointcut("execution(* *..find*(Long))")
	public void argsDemo1(){}
	
	// 匹配任何只有一个Long参数的方法
	@Pointcut("args(Long)")
	public void argsDemo2(){}
	
	// 匹配任何以find开头而且第一个参数为Long型的方法
	@Pointcut("execution(* *..find*(Long,..))")
	public void argsDemo3(){}
	
	// 匹配第一个参数为Long型的方法
	@Pointcut("args(Long,..))")
	public void argsDemo4(){}
	
	
	// 匹配方法标注有AdminOnly的注解的方法
	@Pointcut("@annotation(com.myimooc.springaopguide.security.AdminOnly)")
	public void annoDemo(){}
	
	// 匹配标注有Beta的类底下的方法，要求的annotation的RetentionPolicy级别为CLASS
	@Pointcut("@within(com.google.common.annotations.Beta)")
	public void annoWithDemo(){}
	
	// 匹配标注有Repository的类底下的方法，要求的RetentionPolicy级别为RUNTIME
	@Pointcut("@target(org.springframework.stereotype.Repository)")
	public void annoTargetDemo(){}
	
	// 匹配传入的参数类标注有Repository注解的方法
	@Pointcut("@args(org.springframework.stereotype.Repository)")
	public void annoArgsDemo(){}
	
	// 匹配 使用public修饰符 任意返回值 在com.myimooc.springaopguide.service包及子下 以Service结尾的类 任意方法（任意参数）
	@Pointcut("execution(public * com.myimooc.springaopguide.service..*Service.*(..))")
	public void matchCondition(){}
	
	
	// 定义切点，拦截使用NeedSecured注解修饰的方法
	@Pointcut("@within(com.myimooc.demo.security.NeedSecured)")
	public void annoTargetVsWithinDemo(){}
	
	// 使用NeedSecured注解修饰 且 在com.myimooc包下的方法
	@Before("annoTargetVsWithinDemo() && within(com.myimooc..*)")
	public void beforeDemo(){
		System.out.println("被拦截方法执行之前执行");
	}
	
	@After("annoTargetVsWithinDemo() && within(com.myimooc..*)")
	public void afterDemo(){
		System.out.println("被拦截方法执行之后执行");
	}
	
	@AfterReturning("annoTargetVsWithinDemo() && within(com.myimooc..*)")
	public void afterReturning(){
		System.out.println("代码成功之后执行");
	}
	
	@AfterThrowing("annoTargetVsWithinDemo() && within(com.myimooc..*)")
	public void afterThrowing(){
		System.out.println("代码执行抛出异常之后执行");
	}
	
	@Around("annoTargetVsWithinDemo() && within(com.myimooc..*)")
	public Object aroundDemo(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("相当于@Before");
		try{
			Object result = pjp.proceed(pjp.getArgs());
			System.out.println("相当于@AfterReturning");
			return result;
		}catch (Throwable throwable) {
			System.out.println("相当于@AfterThrowing");
			throw throwable;
		}finally {
			System.out.println("相当于@After");
		}
	}
	
	
	// Advice中的参数及结果绑定
	@Before("annoTargetVsWithinDemo() && within(com.myimooc..*) && args(userId)")
	public void beforeWithArgs(JoinPoint joinPoint,Long userId){
		System.out.println("被拦截方法执行之前执行,args:"+userId);
	}
	
	@AfterReturning(value="annoTargetVsWithinDemo() && within(com.myimooc..*)",returning="returnValue")
	public void getResult(Object returnValue){
		if(returnValue != null){
			System.out.println("代码成功之后执行,result:"+returnValue);
		}
	}
}
