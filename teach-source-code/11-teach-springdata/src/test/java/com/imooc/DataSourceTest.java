package com.imooc;

import com.imooc.dao.StudentDAO;
import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;

public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource(){
        System.out.println("testDataSource");
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }


    @Test
    public void testJdbcTemplate(){
        System.out.println("testJdbcTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }

}
