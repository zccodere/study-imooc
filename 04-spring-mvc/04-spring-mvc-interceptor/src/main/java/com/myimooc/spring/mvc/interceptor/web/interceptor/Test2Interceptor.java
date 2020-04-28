package com.myimooc.spring.mvc.interceptor.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器二
 *
 * @author zc 2017-02-18
 */
public class Test2Interceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(Test2Interceptor.class);

    /**
     * 返回值：表示我们是否需要将当期的请求拦截下来 false：请求会被终止 true：请求会被继续运行 Object object:表示的是被拦截的请求的目标对象
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.debug("执行到了preHandle2方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法。

        logger.debug("执行到了postHandle2方法");

        // modelAndView.addObject("msg","这里传回的是被拦截器修改之后的消息！");
        // modelAndView.setViewName("/hello2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.debug("执行到了afterCompletion2方法");
    }
}
