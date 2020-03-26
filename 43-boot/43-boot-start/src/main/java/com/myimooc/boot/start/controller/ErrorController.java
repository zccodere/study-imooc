package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.domain.JsonResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 跳转至错误页
 *
 * @author zc 2018-04-25
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        // 故意制造异常，以观察效果
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxError() {
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JsonResult getAjaxError() {
        // 故意制造异常，以观察效果
        int a = 1 / 0;
        return JsonResult.ok();
    }
}
