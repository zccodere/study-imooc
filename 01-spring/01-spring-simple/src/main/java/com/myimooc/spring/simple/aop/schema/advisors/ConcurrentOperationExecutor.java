package com.myimooc.spring.simple.aop.schema.advisors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

/**
 * 执行
 *
 * @author zc 2017-01-18
 */
public class ConcurrentOperationExecutor implements Ordered {

    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;

    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        RuntimeException exception;
        do {
            numAttempts++;
            System.out.println("Try times : " + numAttempts);
            try {
                return pjp.proceed();
            } catch (RuntimeException ex) {
                exception = ex;
            }
        } while (numAttempts <= this.maxRetries);
        System.out.println("Try error : " + numAttempts);
        throw exception;
    }
}
