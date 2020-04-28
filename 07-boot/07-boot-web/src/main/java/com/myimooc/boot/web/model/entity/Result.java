package com.myimooc.boot.web.model.entity;

/**
 * http请求返回的实体Bean
 *
 * @author zc 2017-03-19
 */
public class Result<T> {

    /**
     * 响应编号
     */
    private Integer respCode;
    /**
     * 响应消息
     */
    private String respMsg;
    /**
     * 具体的内容
     */
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "respCode=" + respCode +
                ", respMsg='" + respMsg + '\'' +
                ", data=" + data +
                '}';
    }

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
