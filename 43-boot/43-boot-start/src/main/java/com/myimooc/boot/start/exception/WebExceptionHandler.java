package com.myimooc.boot.start.exception;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web请求 异常捕获；使用 @ControllerAdvice 声明当前是助手类；//@ControllerAdvice
 *
 * @author zc 2018-04-25
 */
public class WebExceptionHandler {

    private static final String ERROR_VIEW = "error";

    /**
     * //    @ExceptionHandler(Exception.class)
     */
    public Object handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }
}
