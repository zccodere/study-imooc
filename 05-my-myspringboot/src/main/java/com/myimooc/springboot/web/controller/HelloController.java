package com.myimooc.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangcheng on 2017/2/18.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value="say",method = RequestMethod.GET)
    public String say(){
        return girlProperties.getCupSize();
//        return "index";
    }

//    @RequestMapping(value="/sayy",method = RequestMethod.GET)
    @GetMapping(value="/sayy")
    public String sayy(@RequestParam(value="id",required = false,defaultValue = "0") Integer myId){
        return "id:"+myId;
    }
}
