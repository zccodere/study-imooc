package com.myimooc.sso.same.domain.web.controller;

import com.myimooc.sso.same.domain.web.util.LoginCheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * SSO登录控制器
 *
 * @author zc 2017-03-22
 */
@Controller
@RequestMapping("/sso")
public class LoginController {

    /**
     * 处理用户登录请求
     *
     * @param username 用户名
     * @param password 密码
     * @param gotoUrl  登录成功后请求路径
     */
    @PostMapping("/doLogin")
    public ModelAndView doLogin(String username, String password, String gotoUrl, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("login_fail");
        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username, password);
        // 判断是否登录成功
        if (ok) {
            Cookie cookie = new Cookie(LoginCheck.COOKIE_NAME, LoginCheck.COOKIE_VALUE);
            // 顶级域名下，所有应用都是可见的
            cookie.setPath("/");
            // 添加Cookie
            response.addCookie(cookie);
            mv.setViewName("redirect:" + gotoUrl);
        }
        return mv;
    }

    /**
     * 跳转到登录页面
     */
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}
