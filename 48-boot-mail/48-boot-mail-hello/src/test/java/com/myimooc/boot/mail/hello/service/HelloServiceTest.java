package com.myimooc.boot.mail.hello.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <br>
 * 标题: Hello 服务测试<br>
 * 描述: Hello 服务测试<br>
 * 时间: 2018/09/08<br>
 *
 * @author zc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void sayHelloTest() {
        this.helloService.sayHello();
    }
}