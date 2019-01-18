package com.myimooc.sso.same.father;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启动类<br>
 * 时间: 2017/04/02<br>
 *
 * @author zc
 */
@SpringBootApplication
public class SameFatherApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SameFatherApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SameFatherApplication.class);
    }

}
