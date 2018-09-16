package com.myimooc.spring.mvc.interceptor.service;

import org.springframework.stereotype.Service;

/**
 * helloService
 *
 * @author ChengComputer
 * @version v1.0 2017-02-17
 */
@Service("helloService")
public class HelloService {

    public String sayHello() {
        return "Hello!";
    }
}
