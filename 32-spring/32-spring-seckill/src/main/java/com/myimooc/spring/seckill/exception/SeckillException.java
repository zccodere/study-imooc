package com.myimooc.spring.seckill.exception;

/**
 * 秒杀相关业务异常异常
 *
 * @author zc 2017-08-23
 */
public class SeckillException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
