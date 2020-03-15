package com.myimooc.sso.same.domain.demo1;

import com.myimooc.sso.same.domain.web.util.LoginCheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Demo1 控制层
 *
 * @author zc 2017-04-02
 */
@Controller
public class DemoOneController {

    @RequestMapping("/demo1")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (LoginCheck.checkCookie(request)) {
            mv.setViewName("demo1");
            return mv;
        }
        mv.addObject("gotoUrl", "/demo1");
        mv.setViewName("login");
        return mv;
    }
}
