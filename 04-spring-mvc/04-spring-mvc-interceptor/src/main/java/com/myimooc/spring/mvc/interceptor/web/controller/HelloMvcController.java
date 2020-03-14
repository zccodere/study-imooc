package com.myimooc.spring.mvc.interceptor.web.controller;

import com.myimooc.spring.mvc.interceptor.service.HelloService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 测试控制器
 *
 * @author zc 2017-02-17
 */
@Controller
@RequestMapping("/hello")
public class HelloMvcController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "helloService")
    private HelloService helloService;

    @RequestMapping("/mvc")
    public ModelAndView helloMvc(ModelAndView modelAndView) {
        logger.info("执行" + helloService.sayHello());

        modelAndView.addObject("name", "Thymeleaf");
        modelAndView.setViewName("/home");

        return modelAndView;
    }
}
