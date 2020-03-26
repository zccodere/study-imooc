package com.myimooc.boot.start.exception;


import com.myimooc.boot.start.domain.JsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Ajax 请求 异常捕获；Ajax 形式异常捕获 //@RestControllerAdvice
 *
 * @author zc 2018-04-25
 */
public class AjaxExceptionHandler {

    /**
     * //    @ExceptionHandler(value = Exception.class)
     */
    public JsonResult defaultErrorHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return JsonResult.errException(e.getMessage());
    }
}
