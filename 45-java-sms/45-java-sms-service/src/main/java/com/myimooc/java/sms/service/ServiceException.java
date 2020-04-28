package com.myimooc.java.sms.service;

/**
 * 业务服务异常
 *
 * @author zc
 * @date 2018/05/29
 */
public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
