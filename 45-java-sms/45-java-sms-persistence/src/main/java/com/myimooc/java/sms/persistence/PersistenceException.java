package com.myimooc.java.sms.persistence;

/**
 * 持久化层异常
 *
 * @author zc
 * @date 2018/05/29
 */
public class PersistenceException extends Exception {

    public PersistenceException() {
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }
}
