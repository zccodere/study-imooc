package com.myimooc.spring.aop.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @title 4-2 事务演示
 * @describe 启动类
 * @author zc
 * @version 1.0 2017-09-13
 */
@SpringBootApplication
public class SpringAopTransactionApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringAopTransactionApplication.class, args);
    }
}