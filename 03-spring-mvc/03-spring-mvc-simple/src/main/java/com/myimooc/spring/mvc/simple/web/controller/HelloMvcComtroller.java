package com.myimooc.spring.mvc.simple.web.controller;

import javax.annotation.Resource;

import com.myimooc.spring.mvc.simple.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器
 * @author ChengComputer
 * @version v1.0 2017-02-17
 */
@Controller
@RequestMapping("/hello")
public class HelloMvcComtroller {
    
    @Resource(name="helloService")
    private HelloService helloService;
    
    @RequestMapping("/mvc")
    public String helloMvc(){
        System.out.println("执行"+helloService.sayHello());
        return "home";
    }
}
