package com.myimooc.spring.auth.context;

import com.myimooc.spring.auth.dto.Accordion;
import com.myimooc.spring.auth.entity.User;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter
 *
 * @author zc 2017-08-20
 */
public class UserContextFilter implements Filter {

    private static final String URL_LOGIN = "login";
    public static final String URL_INDEX_JSP = "index.jsp";
    public static final String URL_CSS = ".css";
    public static final String URL_JS = ".js";

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ResponseContext.setCurrent(response);

        if (request.getRequestURI().contains(URL_LOGIN)) {
            Cookie cookie = new Cookie("auth", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (request.getRequestURI().contains(URL_INDEX_JSP)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (request.getRequestURI().endsWith(URL_CSS) || request.getRequestURI().endsWith(URL_JS)
                || request.getRequestURI().endsWith(".jpg") || request.getRequestURI().endsWith(".png")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取cookie
        String cookieValue = "";
        if (null != request.getCookies()) {
            for (Cookie cookie : request.getCookies()) {
                if (Objects.equals("auth", cookie.getName())) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }

        // 解密cookie
        byte[] bytes = Base64.getDecoder().decode(cookieValue);
        String auth = new String(bytes);

        int count = 2;
        String[] array = auth.split("\\$");
        if (count == array.length) {
            User user = LoginUserCache.get(array[0]);
            if (null == user) {
                LoginUserHelper helper = WebApplicationContext.getBean(LoginUserHelper.class);
                helper.executeLogin(array[0], array[1]);
                user = LoginUserCache.get(array[0]);
            }
            if (null != user && Objects.equals(user.getPwd(), array[1])) {
                List<Accordion> sccordions = LoginUserCache.getAccordions(user.getName());
                request.setAttribute("sccordions", sccordions);
                UserContext.setCurrent(user);
                LoginUserCache.setCookie(user);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            } else {
                Cookie cookie = new Cookie("auth", null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.sendRedirect("/index.jsp");
            }
        } else {
            Cookie cookie = new Cookie("auth", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
