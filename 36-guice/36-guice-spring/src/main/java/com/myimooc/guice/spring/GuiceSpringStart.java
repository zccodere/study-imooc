package com.myimooc.guice.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @title 启动类
 * @describe Guice与SpringBoot协作
 * @author zc
 * @version 1.0 2017-10-15
 */
@SpringBootApplication
@ServletComponentScan
public class GuiceSpringStart {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GuiceSpringStart.class, args);
    }
}
