package com.myimooc.mail.register.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myimooc.mail.register.domain.User;
import com.myimooc.mail.register.service.UserService;
import com.myimooc.mail.register.util.UuidUtils;

/**
 * <br>
 * 标题: 用户Controller<br>
 * 描述: 用户Controller<br>
 * 时间: 2017/06/07<br>
 *
 * @author zc
 */
@Controller
public class RegistController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @GetMapping("/regist")
    public ModelAndView toRegistPage() {
        return new ModelAndView("regist");
    }

    /**
     * 处理用户注册请求
     *
     * @return
     */
    @PostMapping("/regist")
    public ModelAndView regist(User user) {
        // 0，未激活；1，已激活
        user.setState(0);
        String code = UuidUtils.getUuid() + UuidUtils.getUuid();
        user.setCode(code);
        // 调用业务层处理数据
        userService.regist(user);
        // 页面跳转

        return new ModelAndView("regist");
    }

    /**
     * 处理用户激活请求
     *
     * @return
     */
    @GetMapping("/regist/active")
    @ResponseBody
    public Object registActive(@RequestParam("code") String code) {

        boolean result = userService.registActive(code);

        return "激活状态：" + result;
    }


}
