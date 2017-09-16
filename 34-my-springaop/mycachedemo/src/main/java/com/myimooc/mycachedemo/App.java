package com.myimooc.mycachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @title 4-4 缓存演示
 * @describe 启动类
 * @author zc
 * @version 1.0 2017-09-13
 */
@SpringBootApplication
@EnableCaching
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}