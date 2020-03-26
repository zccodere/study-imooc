package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.domain.JsonResult;
import com.myimooc.boot.start.domain.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返直接返回方法的响应内容
 *
 * @author zc 2018-04-19
 */
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @GetMapping("/hello")
    public Object hello() {
        return "Hello SpringBoot！";
    }

    @GetMapping("/getResource")
    public JsonResult getResource() {
        Resource target = new Resource();
        BeanUtils.copyProperties(resource, target);
        return JsonResult.ok(target);
    }
}
