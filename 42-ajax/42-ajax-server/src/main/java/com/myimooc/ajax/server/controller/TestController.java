package com.myimooc.ajax.server.controller;

import com.myimooc.ajax.server.vo.ResultBean;
import com.myimooc.ajax.server.vo.User;
import org.springframework.web.bind.annotation.*;

/**
 * <br>
 * 标题: 测试控制器<br>
 * 描述: 提供REST服务<br>
 * 使用 @CrossOrigin 注解支持跨域，可以放到类或方法上面
 * //@CrossOrigin
 *
 * @author zc
 * @date 2018/04/18
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get1")
    public ResultBean get1() {
        System.out.println("TestController.get1");
        return new ResultBean("get1ok");
    }

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user) {
        System.out.println("TestController.postJson");
        return new ResultBean("postJson" + user.getName());
    }

    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue(value = "cookie1") String cookie1) {
        System.out.println("TestController.getCookie");
        return new ResultBean("getCookie" + cookie1);
    }

    @GetMapping("/getHeader")
    public ResultBean getHeader(
            @RequestHeader("x-header1") String header1,
            @RequestHeader("x-header2") String header2) {
        System.out.println("TestController.getHeader");
        return new ResultBean("getHeader" + header1 + header2);
    }
}
