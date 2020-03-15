package com.myimooc.sso.same.father.util;

import java.io.Serializable;

/**
 * 接口响应对象
 *
 * @author zc 2017-04-02
 */
public class RespMessage implements Serializable {

    /**
     * 响应编号
     */
    private String respCode;
    /**
     * 响应消息
     */
    private String respMsg;

    @Override
    public String toString() {
        return "RespMessage{" +
                "respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                '}';
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
