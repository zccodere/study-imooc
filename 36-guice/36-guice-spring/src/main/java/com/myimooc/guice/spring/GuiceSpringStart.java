package com.myimooc.guice.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 *
 * @author zc 2017-10-15
 */
@SpringBootApplication
@ServletComponentScan
public class GuiceSpringStart {

    public static void main(String[] args) {
        SpringApplication.run(GuiceSpringStart.class, args);
    }
}
