package com.myimooc.boot.small.server.handler;

import com.myimooc.boot.small.server.vo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <br>
 * 标题: 全局异常处理类<br>
 * 描述: 统一处理异常<br>
 *
 * @author zc
 * @date 2018/04/17
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setErrMsg(e.getMessage());
        return response;
    }
}
