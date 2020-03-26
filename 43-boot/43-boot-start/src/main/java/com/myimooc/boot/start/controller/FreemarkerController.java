package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.domain.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 整合 Freemarker
 *
 * @author zc 2018-04-25
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @GetMapping("/center")
    public String center() {
        return "freemarker/center/center";
    }
}
