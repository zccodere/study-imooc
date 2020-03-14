package com.myimooc.spring.mvc.interceptor.service;

import org.springframework.stereotype.Service;

/**
 * helloService
 *
 * @author zc 2017-02-18
 */
@Service("helloService")
public class HelloService {

    public String sayHello() {
        return "Hello!";
    }
}
