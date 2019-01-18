package com.myimooc.boot.web.model.entity;

/**
 * http请求返回的实体Bean
 * @author ZhangCheng
 * @date 2017-03-19
 * @version  V1.0
 */
public class Result<T> {

    /** 响应编号 */
    private Integer respCode;

    /** 响应消息 */
    private String respMsg;

    /** 具体的内容 */
    private T data;

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
