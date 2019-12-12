package com.imooc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;

public class CrosFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String origin = req.getHeader("Origin");
		
		if (!org.springframework.util.StringUtils.isEmpty(origin)) {
			//带cookie的时候，origin必须是全匹配，不能使用*
			res.addHeader("Access-Control-Allow-Origin", origin);			
		}
		
		res.addHeader("Access-Control-Allow-Methods", "*");
		
		String headers = req.getHeader("Access-Control-Request-Headers");
		
		// 支持所有自定义头
		if (!org.springframework.util.StringUtils.isEmpty(headers)) {
			res.addHeader("Access-Control-Allow-Headers", headers);			
		}
		
		res.addHeader("Access-Control-Max-Age", "3600");
		
		// enable cookie
		res.addHeader("Access-Control-Allow-Credentials", "true");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
