package com.myimooc.guice.spring.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import com.myimooc.guice.spring.dao.SampleDao;

import org.springframework.context.ApplicationContext;

/**
 * Module配置类；Spring相关依赖配置
 *
 * @author zc 2017-10-15
 */
public class SpringAwareServletModule extends AbstractModule {

    private final ApplicationContext context;

    public SpringAwareServletModule(ApplicationContext context) {
        this.context = context;
    }

    @Override
    protected void configure() {
        install(new ServletModule());
        bind(ApplicationContext.class).toInstance(context);
    }

    @Provides
    SampleDao getSampleDaoSampleDao(ApplicationContext context) {
        return context.getBean(SampleDao.class);
    }
}
