package com.myimooc.spring.mvc.interceptor.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-18
 *
 */
public class Test2Interceptor implements HandlerInterceptor{
    
    private Logger log = LoggerFactory.getLogger(Test2Interceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        
        log.debug("执行到了afterCompletion2方法");
        
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView mv)
            throws Exception {
        
        //可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法。
        
        log.debug("执行到了postHandle2方法");
        
//        mv.addObject("msg","这里传回的是被拦截器修改之后的消息！");
//        mv.setViewName("/hello2");
    }
    
    /**
     * 返回值：表示我们是否需要将当期的请求拦截下来
     * false：请求会被终止
     * true：请求会被继续运行
     * Object object:表示的是被拦截的请求的目标对象
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        
        log.debug("执行到了preHandle2方法");
        
        return true;
    }

}
