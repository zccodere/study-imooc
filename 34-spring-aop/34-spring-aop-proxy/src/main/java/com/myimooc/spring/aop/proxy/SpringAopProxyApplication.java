package com.myimooc.spring.aop.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 3-3 代理模式；启动类；@EnableAspectJAutoProxy(proxyTargetClass=true) 强制使用cglib代理
 *
 * @author zc 2017-09-13
 * @version 1.0 2017-09-13
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class SpringAopProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopProxyApplication.class, args);
    }
}
