package com.myimooc.springbootweb.utils;

/**
 * http请求返回的消息响应编号
 * @author ZhangCheng
 * @date 2017-03-19
 * @version  V1.0
 */
public enum ResultResp {

    SUCCESS(0,"成功"),
    UNKONW_ERROR(-1,"未知错误"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中")
    ;
    private Integer respCode;

    private String respMsg;

    ResultResp(Integer respCode, String respMsg) {
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
