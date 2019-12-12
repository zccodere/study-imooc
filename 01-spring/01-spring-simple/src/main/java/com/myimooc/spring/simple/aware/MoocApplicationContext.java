package com.myimooc.spring.simple.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <br>
 * 标题: ApplicationContextAware扩展接口<br>
 * 描述: 获取ApplicationContext<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocApplicationContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("MoocApplicationContext : " + applicationContext.getBean("moocApplicationContext").hashCode());
    }

}
