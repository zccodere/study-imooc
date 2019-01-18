package com.myimooc.java.sms.persistence;

/**
 * <br>
 * 标题: 持久化层异常<br>
 * 描述: 持久化层异常<br>
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
