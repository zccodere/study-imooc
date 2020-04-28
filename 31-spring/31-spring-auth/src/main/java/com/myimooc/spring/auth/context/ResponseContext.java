package com.myimooc.spring.auth.context;

import javax.servlet.http.HttpServletResponse;

/**
 * 响应上下文
 *
 * @author zc 2017-08-20
 */
public class ResponseContext {

    private static ThreadLocal<HttpServletResponse> local = new ThreadLocal<>();

    static void setCurrent(HttpServletResponse response) {
        local.set(response);
    }

    static HttpServletResponse getCurrent() {
        return local.get();
    }

    public static void remove() {
        local.remove();
    }
}
