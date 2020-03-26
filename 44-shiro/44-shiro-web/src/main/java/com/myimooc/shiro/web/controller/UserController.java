package com.myimooc.shiro.web.controller;

import com.myimooc.shiro.web.constant.Constants;
import com.myimooc.shiro.web.vo.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户Controller；处理用户相关请求
 *
 * @author zc 2018-05-02
 */
@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/403")
    public String to403() {
        return "403";
    }

    @PostMapping("/subLogin")
    @ResponseBody
    public String subLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            // 设置自动登录
            token.setRememberMe(user.getRememberMe());
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        if (subject.hasRole(Constants.Role.ADMIN)) {
            return "有admin权限";
        }

        return "无admin权限";
    }

    @GetMapping("/testRole")
    @ResponseBody
    public String testRole() {
        return "testRole Success";
    }

    @GetMapping("/testRole1")
    @ResponseBody
    public String testRole1() {
        return "testRole1 Success";
    }

    @GetMapping("/testPerms")
    @ResponseBody
    public String testPerms() {
        return "testPerms Success";
    }

    @GetMapping("/testPerms1")
    @ResponseBody
    public String testPerms1() {
        return "testPerms1 Success";
    }
}
