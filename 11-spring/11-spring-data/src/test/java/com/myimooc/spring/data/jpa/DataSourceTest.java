package com.myimooc.spring.data.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * 数据源测试类
 *
 * @author zc 2017-04-24
 */
public class DataSourceTest extends AbstractTestSupport {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void dataSourceTest() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = ctx.getBean(LocalContainerEntityManagerFactoryBean.class);
        logger.info("数据源：{}", entityManagerFactory.getDataSource());
        Assert.assertNotNull(entityManagerFactory.getDataSource());
    }

    @Test
    public void entityManagerFactoryTest() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = ctx.getBean(LocalContainerEntityManagerFactoryBean.class);
        System.out.println(entityManagerFactory.toString());
        Assert.assertNotNull(entityManagerFactory);
    }
}
