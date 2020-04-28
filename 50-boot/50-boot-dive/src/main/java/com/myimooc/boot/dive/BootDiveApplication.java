package com.myimooc.boot.dive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 *
 * @author zc
 * @date 2018/10/10
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.myimooc.boot.dive.web.servlet")
public class BootDiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDiveApplication.class, args);
    }

}
