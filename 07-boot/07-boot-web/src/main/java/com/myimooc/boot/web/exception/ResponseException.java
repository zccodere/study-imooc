package com.myimooc.boot.web.exception;

import com.myimooc.boot.web.utils.ResultResponse;

/**
 * 自定义项目异常类
 *
 * @author zc 2017-03-19
 */
public class ResponseException extends RuntimeException {

    /**
     * 响应编号
     */
    private Integer respCode;

    public ResponseException(ResultResponse resultResponse) {
        super(resultResponse.getRespMsg());
        this.respCode = resultResponse.getRespCode();
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }
}

