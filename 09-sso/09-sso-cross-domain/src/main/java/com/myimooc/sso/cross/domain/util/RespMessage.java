package com.myimooc.sso.cross.domain.util;

import java.io.Serializable;
import java.util.Map;

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
    /**
     * 响应数据
     */
    private Map<String, Object> respArgs;

    @Override
    public String toString() {
        return "RespMessage{" +
                "respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                ", respArgs=" + respArgs +
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

    public Map<String, Object> getRespArgs() {
        return respArgs;
    }

    public void setRespArgs(Map<String, Object> respArgs) {
        this.respArgs = respArgs;
    }
}
