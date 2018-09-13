package com.myimooc.qrcode.jquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目启动入口
 *
 * @author ZhangCheng on 2017-06-23
 */
@SpringBootApplication
public class QrcodeJqueryApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(QrcodeJqueryApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QrcodeJqueryApplication.class);
    }
}
