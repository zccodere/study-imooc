package com.myimooc.guice.spring.service.greeting;

import com.google.inject.Provider;

import com.myimooc.guice.spring.dao.SampleDao;

import javax.inject.Inject;

/**
 * 处理Greeting相关请求，并返回结果
 *
 * @author zc 2017-10-15
 */
public class GreetingMessageProvider implements Provider<String> {

    private final RequestParams params;
    private final SampleDao dao;

    @Inject
    public GreetingMessageProvider(RequestParams params, SampleDao dao) {
        super();
        this.params = params;
        this.dao = dao;
    }

    @Override
    public String get() {
        String name = params.getGreetingName();
        dao.getPersonData(name);
        return "Hello " + name;
    }

}
