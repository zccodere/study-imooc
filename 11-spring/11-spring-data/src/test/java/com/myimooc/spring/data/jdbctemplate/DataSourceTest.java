package com.myimooc.spring.data.jdbctemplate;

import com.myimooc.spring.data.jdbctemplate.config.SpringConfig;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 数据源测试类
 *
 * @author zc 2017-04-24
 */
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("init");
    }

    @After
    public void destroy() {
        ctx = null;
        System.out.println("destroy");
    }

    @Test
    public void dataSourceTest() {
        DataSource dataSource = ctx.getBean(DriverManagerDataSource.class);
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void jdbcTemplateTest() {
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        System.out.println("jdbcTemplateTest");
        Assert.assertNotNull(jdbcTemplate);
    }

}
