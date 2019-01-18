package com.myimooc.boot.dive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启动类<br>
 * 时间: 2018/10/10<br>
 *
 * @author zc
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.myimooc.boot.dive.web.servlet")
public class BootDiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDiveApplication.class, args);
    }

}
