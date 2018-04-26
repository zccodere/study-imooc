package com.myimooc.boot.start.exception;


import com.myimooc.boot.start.domain.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <br>
 * 标题: Ajax 请求 异常捕获<br>
 * 描述: Ajax 形式异常捕获<br>
 *
 * @author zc
 * @date 2018/04/25
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return JsonResult.errException(e.getMessage());
    }
}
