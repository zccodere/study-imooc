package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.domain.JsonResult;
import com.myimooc.boot.start.domain.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <br>
 * 使用Controller；返回JSON数据
 *
 * @author zc 2018-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("myImooc2");
        user.setPassword("myImooc");
        user.setAge(22);
        user.setBirthday(new Date());
        user.setNote("Hello");
        return user;
    }

    @GetMapping("/getUserJson")
    public JsonResult getUserJson() {
        User user = new User();
        user.setName("myImooc2");
        user.setPassword("myImooc");
        user.setAge(22);
        user.setBirthday(new Date());
        user.setNote("Hello");
        return JsonResult.ok(user);
    }

}
