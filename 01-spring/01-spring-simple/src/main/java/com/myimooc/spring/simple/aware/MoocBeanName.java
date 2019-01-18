package com.myimooc.spring.simple.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <br>
 * 标题: BeanNameAware扩展接口<br>
 * 描述: 获取Bean名称<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocBeanName implements BeanNameAware, ApplicationContextAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("MoocBeanName : " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("setApplicationContext : " + applicationContext.getBean(this.beanName).hashCode());
    }

}
