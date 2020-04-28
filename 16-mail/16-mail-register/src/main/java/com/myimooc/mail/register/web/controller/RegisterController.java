package com.myimooc.mail.register.web.controller;

import com.myimooc.mail.register.domain.User;
import com.myimooc.mail.register.service.UserService;
import com.myimooc.mail.register.util.UuidUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户注册控制层
 *
 * @author zc 2017-06-07
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到注册页面
     *
     * @return 注册视图
     */
    @GetMapping
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    /**
     * 处理用户注册请求
     *
     * @return 注册视图
     */
    @PostMapping
    public ModelAndView register(User user) {
        // 0，未激活；1，已激活
        user.setState(0);
        String code = UuidUtils.getUuid() + UuidUtils.getUuid();
        user.setCode(code);
        // 调用业务层处理数据
        userService.register(user);
        // 页面跳转
        return new ModelAndView("register");
    }

    /**
     * 处理用户激活请求
     *
     * @return 激活状态
     */
    @GetMapping("/active")
    @ResponseBody
    public Object registerActive(@RequestParam("code") String code) {
        boolean result = userService.registerActive(code);
        return "激活状态：" + result;
    }
}
