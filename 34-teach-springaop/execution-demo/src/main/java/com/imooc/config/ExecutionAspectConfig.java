package com.imooc.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * //匹配任何公共方法
 @Pointcut("execution(public * com.imooc.service.*.*(..))")

 //匹配com.imooc包及子包下Service类中无参方法
 @Pointcut("execution(* com.imooc..*Service.*())")

 //匹配com.imooc包及子包下Service类中的任何只有一个参数的方法
 @Pointcut("execution(* com.imooc..*Service.*(*))")

 //匹配com.imooc包及子包下任何类的任何方法
 @Pointcut("execution(* com.imooc..*.*(..))")

 //匹配com.imooc包及子包下返回值为String的任何方法
 @Pointcut("execution(String com.imooc..*.*(..))")

 //匹配异常
 execution(public * com.imooc.service.*.*(..) throws java.lang.IllegalAccessException)

 * Created by cat on 2017-02-19.
 */
@Aspect
@Component
public class ExecutionAspectConfig {

// @Pointcut("execution(public * com.imooc.service..*Service.*(..) throws java.lang.IllegalAccessException)")
// public void matchCondition(){}
//
// @Before("matchCondition()")
// public void before(){
//  System.out.println("");
//  System.out.println("###before");
// }

}
