package com.myimooc.spring.mvc.interceptor.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试控制器
 *
 * @author zc 2017-02-17
 */
@Controller
@RequestMapping("/")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/view/all")
    public ModelAndView viewAll(String name, String pwd, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        logger.debug("进入了控制器的viewAll方法");
        logger.debug("name=" + name + ",pwd=" + pwd);

        request.getSession().setAttribute("user", name);

        mv.setViewName("/hello1");
        mv.addObject("msg", "恭喜 " + name + " 登录成功！");

        return mv;
    }

    @RequestMapping("/query")
    public ModelAndView query(String name, String pwd) {
        ModelAndView mv = new ModelAndView();
        logger.debug("进入了控制器的viewAll方法");
        logger.debug("name=" + name + ",pwd=" + pwd);
        mv.setViewName("/hello1");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView doLogin() {
        return new ModelAndView("/login");
    }
}
