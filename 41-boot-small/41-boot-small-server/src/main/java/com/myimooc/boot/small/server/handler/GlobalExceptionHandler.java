package com.myimooc.boot.small.server.handler;

import com.myimooc.boot.small.server.vo.BaseResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类；统一处理异常
 *
 * @author zc 2018-04-17
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setErrMsg(e.getMessage());
        return response;
    }
}
