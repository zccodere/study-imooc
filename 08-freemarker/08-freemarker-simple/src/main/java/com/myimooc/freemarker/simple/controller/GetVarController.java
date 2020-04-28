package com.myimooc.freemarker.simple.controller;

import com.myimooc.freemarker.simple.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 取值控制层
 *
 * @author zc 2017-03-19
 */
@Controller
@RequestMapping("/")
public class GetVarController {

    @GetMapping("/macro")
    public ModelAndView macro() {
        return new ModelAndView("macro");
    }

    @GetMapping("/method")
    public ModelAndView method() {
        return new ModelAndView("method");
    }

    @GetMapping("/var")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("var");

        // 定义基本数据类型
        mv.addObject("intVar", 100);
        mv.addObject("longVar", 10000L);
        mv.addObject("stringVar", "我是字符串");
        mv.addObject("doubleVar", 3.45d);
        mv.addObject("booleanVar", true);
        mv.addObject("dateVar", new Date());
        mv.addObject("nullVar", "我是null");

        // 定义封装对象
        User user = new User();
        user.setName("freemarker");
        mv.addObject("userObj", user);

        // 定义富文本
        String brief = "<font color='red'>我只想早点下班。对不起，你是程序员！</font>";
        mv.addObject("briefVar", brief);

        // 定义List集合
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("nodejs");
        mv.addObject("myList", list);

        // 定义Map集合
        Map<String, String> map = new HashMap<>(16);
        map.put("java", "你好java");
        map.put("python", "你好python");
        map.put("nodejs", "你好nodejs");
        mv.addObject("map", map);

        // 定义整数排序方法
        mv.addObject("sort_int", new SortMethod());

        return mv;
    }

}
