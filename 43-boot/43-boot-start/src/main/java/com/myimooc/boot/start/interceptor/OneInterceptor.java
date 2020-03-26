package com.myimooc.boot.start.interceptor;

import com.myimooc.boot.start.domain.JsonResult;
import com.myimooc.boot.start.util.JsonUtils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器一
 *
 * @author zc 2018-04-26
 */
public class OneInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {

        System.out.println("被one拦截，放行...");
        return true;

//         当校验不通过时，返回 ajax 错误信息
//        if (true) {
//            this.returnErrorResponse(response, JsonResult.errMsg("被one拦截"));
//        }
//        return false;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView mv)
            throws Exception {
        // 可以修改返回的数据
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行 （主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception ex)
            throws Exception {

    }

    private void returnErrorResponse(HttpServletResponse response, JsonResult result) throws Exception {
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
