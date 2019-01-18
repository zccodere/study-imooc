package com.myimooc.boot.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ZhangCheng
 * @date 2017-03-19
 * @version V1.0
 *
 */
@Aspect
@Component
public class HttpAspect {

    /** 日志 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    /** 定义切点 */
    @Pointcut("execution(public * com.myimooc.boot.web.controller.GirlController.*(..))")
    public void log(){}

    /** 前置通知 */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        LOGGER.info("url={}",request.getRequestURI());

        // method
        LOGGER.info("method={}",request.getMethod());

        // ip
        LOGGER.info("ip={}",request.getRemoteAddr());

        // 类方法
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // 参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    /** 后置通知 */
    @After("log()")
    public void doAfter(){
        LOGGER.info("方法执行之后执行");
    }

    /** 正常返回通知 */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
//        LOGGER.info("response={}",object.toString());
    }

}

