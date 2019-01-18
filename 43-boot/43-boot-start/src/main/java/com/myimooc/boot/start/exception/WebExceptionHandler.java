package com.myimooc.boot.start.exception;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * 标题: Web请求 异常捕获<br>
 * 描述: 使用 @ControllerAdvice 声明当前是助手类<br>
 * //@ControllerAdvice
 *
 * @author zc
 * @date 2018/04/25
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
