package com.myimooc.spring.simple.aop.schema.advisors.service;

import org.springframework.stereotype.Service;

/**
 * 服务
 *
 * @author zc 2017-01-18
 */
@Service
public class InvokeService {

    public void invoke() {
        System.out.println("InvokeService ......");
    }

    public void invokeException() {
        throw new RuntimeException("手动抛异常进行模拟");
    }

}
