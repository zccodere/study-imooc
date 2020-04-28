package com.myimooc.guice.spring.service.greeting;

import com.google.inject.servlet.RequestScoped;

/**
 * POJO类；封装message信息
 *
 * @author zc 2017-10-15
 */
@RequestScoped
public class RequestParams {

    private String greetingName;

    public String getGreetingName() {
        return greetingName;
    }

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }
}
