package com.myimooc.spring.mvc.interceptor.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试控制器
 * @author ChengComputer
 * @version v1.0 2017-02-17
 */
@Controller
@RequestMapping("/")
public class TestController {
    
    private Logger log = LoggerFactory.getLogger(TestController.class);
    
    @RequestMapping("/viewall")
    public ModelAndView viewAll(String name,String pwd,HttpServletRequest request){
        ModelAndView mv= new ModelAndView();
        
        log.debug("进入了控制器的viewAll方法");
        log.debug("name="+name+",pwd="+pwd);
        
        request.getSession().setAttribute("user", name);
        
        mv.setViewName("/hello1");
        mv.addObject("msg","恭喜 "+name+" 登录成功！");
        
        return mv;
    }
    
    @RequestMapping("/query")
    public ModelAndView query(String name,String pwd){
        ModelAndView mv= new ModelAndView();
        
        log.debug("进入了控制器的viewAll方法");
        log.debug("name="+name+",pwd="+pwd);
        
        
        mv.setViewName("/hello1");
        return mv;
    }
    
    @RequestMapping("/login")
    public ModelAndView doLogin(){
        return new ModelAndView("/login");
    }
}
