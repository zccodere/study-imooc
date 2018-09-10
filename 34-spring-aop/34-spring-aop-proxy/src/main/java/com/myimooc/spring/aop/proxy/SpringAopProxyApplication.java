package com.myimooc.spring.aop.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @title 3-3 代理模式
 * @describe 启动类
 * // @EnableAspectJAutoProxy(proxyTargetClass=true) 强制使用cglib代理
 * @author zc
 * @version 1.0 2017-09-13
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopProxyApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringAopProxyApplication.class, args);
    }
}
