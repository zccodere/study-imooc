package com.myimooc.myproxydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @title 3-3 代理模式
 * @describe 启动类
 * @author zc
 * @version 1.0 2017-09-13
 */
@SpringBootApplication
// 强制使用chlib代理
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ProxyDemoApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProxyDemoApplication.class, args);
    }
}
