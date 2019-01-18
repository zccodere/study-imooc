package com.myimooc.spring.data.jpa;

import com.myimooc.spring.data.jpa.config.SpringConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by ZC on 2017/4/24.
 */
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("init");
    }

    @After
    public void destroy(){
        ctx = null;
        System.out.println("destroy");
    }

    @Test
    public void dataSourceTest(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = ctx.getBean(LocalContainerEntityManagerFactoryBean.class);
        System.out.println(entityManagerFactory.getDataSource().toString());
        Assert.assertNotNull(entityManagerFactory.getDataSource());
    }

    @Test
    public void entityManagerFactoryTest(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = ctx.getBean(LocalContainerEntityManagerFactoryBean.class);
        System.out.println(entityManagerFactory.toString());
        Assert.assertNotNull(entityManagerFactory);
    }

}
