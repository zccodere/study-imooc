package com.myimooc.boot.web.controller;

import com.myimooc.boot.web.config.GirlProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello 控制层
 *
 * @author zc 2017-02-18
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "say", method = RequestMethod.GET)
    @ResponseBody
    public String say() {
        return girlProperties.getCupSize();
    }

    @GetMapping(value = "/say/one")
    @ResponseBody
    public String sayOne(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id:" + myId;
    }
}
