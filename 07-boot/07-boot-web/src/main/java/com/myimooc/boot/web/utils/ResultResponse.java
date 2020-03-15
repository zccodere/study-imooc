package com.myimooc.boot.web.utils;

/**
 * http请求返回的消息响应编号
 *
 * @author zc 2017-03-19
 */
public enum ResultResponse {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 未知异常
     */
    UNKONW_ERROR(-1, "未知错误"),
    /**
     * 你可能还在上小学
     */
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    /**
     * 你可能在上初中
     */
    MIDDLE_SCHOOL(101, "你可能在上初中");

    private Integer respCode;

    private String respMsg;

    ResultResponse(Integer respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }
}
