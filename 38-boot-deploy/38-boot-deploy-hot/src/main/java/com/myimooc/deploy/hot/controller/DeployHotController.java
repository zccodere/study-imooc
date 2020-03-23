package com.myimooc.deploy.hot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器
 *
 * @author zc 2017-12-01
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
