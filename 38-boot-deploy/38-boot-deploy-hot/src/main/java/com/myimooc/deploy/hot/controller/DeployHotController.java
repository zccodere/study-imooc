package com.myimooc.deploy.hot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zc
 * @version 1.0 2017-12-01
 * @title 控制器
 * @describe
 */
@Controller
public class DeployHotController {

    /**
     * // 等价于 @RequestMapping(value="/say",method=RequestMethod.GET)
     *
     * @param request 请求
     * @return 首页
     */
    @GetMapping("/say")
    public String say(HttpServletRequest request) {
        request.setAttribute("say", "Hello Spring Boot!");
        return "index";
    }
}
