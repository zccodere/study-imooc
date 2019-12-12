package com.myimooc.java.sms.service;

/**
 * <br>
 * 标题: 业务服务异常<br>
 * 描述: 业务服务异常<br>
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
