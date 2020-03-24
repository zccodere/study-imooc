package com.myimooc.ajax.server.config;

import org.springframework.util.StringUtils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务端解决跨域；使用Filter
 *
 * @author zc 2018-04-18
 */
public class CrosFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        // 指定允许的域，带cookie时，origin必须是全匹配，不能使用
        // res.addHeader("Access-Control-Allow-Origin","http://localhost:8081");
        // 允许所有域，但不能满足带 cookie 的跨域请求
        // res.addHeader("Access-Control-Allow-Origin","*");
        // 允许所有header
        // res.addHeader("Access-Control-Allow-Headers","*");
        // 指定允许的方法
        // res.addHeader("Access-Control-Allow-Methods","GET");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;

        HttpServletRequest req = (HttpServletRequest) request;

        String origin = req.getHeader("Origin");
        if (!StringUtils.isEmpty(origin)) {
            // 支持任何域名的跨域调用 且 支持带cookie（是被调用方域名的cookie，而不是调用方的cookie）
            res.addHeader("Access-Control-Allow-Origin", origin);
        }

        // 支持所有自定义头
        String headers = req.getHeader("Access-Control-Allow-Headers");
        if (!StringUtils.isEmpty(headers)) {
            // 允许所有header
            res.addHeader("Access-Control-Allow-Headers", headers);
        }

        // 允许所有方法
        res.addHeader("Access-Control-Allow-Methods", "*");
        // 允许浏览器在一个小时内，缓存跨域访问信息（即上面三个信息）
        res.addHeader("Access-Control-Max-Age", "3600");
        // 启用 cookie
        res.addHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
