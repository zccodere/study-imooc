package com.myimooc.boot.simple.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <br>
 * 标题: Controller<br>
 * 描述: Controller<br>
 * 时间: 2017/02/18<br>
 *
 * @author zc
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "say", method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize();
//        return "index";
    }

    @GetMapping(value = "/sayy")
    public String sayy(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id:" + myId;
    }
}
