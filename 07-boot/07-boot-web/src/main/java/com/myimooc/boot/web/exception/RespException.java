package com.myimooc.boot.web.exception;

import com.myimooc.boot.web.utils.ResultResp;

/**
 * 自定义项目异常类
 * @author ZhangCheng
 * @date 2017-03-19
 * @version V1.0
 *
 */
public class RespException extends RuntimeException{
    /** 响应编号 */
    private Integer respCode;

    public RespException(ResultResp resultResp) {
        super(resultResp.getRespMsg());
        this.respCode = resultResp.getRespCode();
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }
}

