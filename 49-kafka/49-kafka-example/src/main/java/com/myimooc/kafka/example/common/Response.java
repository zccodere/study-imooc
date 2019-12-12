package com.myimooc.kafka.example.common;

import java.io.Serializable;

/**
 * <br>
 * 标题: REST请求统一响应对象<br>
 * 描述: REST请求统一响应对象<br>
 * 时间: 2018/09/09<br>
 *
 * @author zc
 */
public class Response implements Serializable {

    private static final long serialVersionUID = -972246069648445912L;
    /**
     * 响应编码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;

    public Response() {
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
