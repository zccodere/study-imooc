package com.myimooc.spring.auth.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * IOC容器获取
 *
 * @author zc 2017-08-19
 */
@Component
public class WebApplicationContext implements ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        ctx = context;
    }

    static <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);
    }
}
