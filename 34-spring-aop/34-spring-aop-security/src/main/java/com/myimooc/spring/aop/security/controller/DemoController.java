package com.myimooc.spring.aop.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器类；演示控制器类
 *
 * @author zc 2017-09-13
 */
@RestController
public class DemoController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/common")
    public String commonAccess() {
        return "only login can view";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin() {
        return "only admin can view";
    }

}
