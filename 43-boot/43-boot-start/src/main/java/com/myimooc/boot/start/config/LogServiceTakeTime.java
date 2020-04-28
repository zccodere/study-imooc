package com.myimooc.boot.start.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用 AOP；service的方法执行需要多少时间统计
 *
 * @author zc 2018-04-26
 */
@Aspect
@Component
public class LogServiceTakeTime {

    private static final long TIMEOUT_ERROR = 10;
    private static final long TIMEOUT_WARN = 5;
    private static final long TIMEOUT_INFO = 2;

    private final static Logger log = LoggerFactory.getLogger(LogServiceTakeTime.class);

    @Pointcut("execution(* com.myimooc.boot.start.service..*.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录起始时间
        long begin = System.currentTimeMillis();

        // 执行目标方法
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.error("日志记录发生错误, errorMessage: {}", e.getMessage());
        } finally {
            // 记录操作时间
            long took = (System.currentTimeMillis() - begin) / 1000;
            if (took >= TIMEOUT_ERROR) {
                log.error("Service 执行时间为: {}秒", took);
            } else if (took >= TIMEOUT_WARN) {
                log.warn("Service 执行时间为: {}秒", took);
            } else if (took >= TIMEOUT_INFO) {
                log.info("Service执行时间为: {}秒", took);
            }
        }
        return result;
    }

    @Before("performance()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        log.info("doBefore");
    }

    @AfterReturning(returning = "ret", pointcut = "performance()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("doAfterReturning");
    }

}
