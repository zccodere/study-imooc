package com.myimooc.spring.data.jpa.service;

import com.myimooc.spring.data.jpa.config.SpringConfig;
import com.myimooc.spring.data.jpa.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * EmployeeService单元测试类
 * Created by ZC on 2017/4/25.
 */
public class EmployeeServiceTest {

    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        employeeService = ctx.getBean(EmployeeService.class);
    }

    @After
    public void destroy(){
        ctx = null;
    }

    @Test
    public void transactionManagerTest(){
        PlatformTransactionManager transactionManager = (PlatformTransactionManager)ctx.getBean(PlatformTransactionManager.class);
        Assert.assertNotNull(transactionManager);
    }

    // 更新操作

    @Test
    public void updateAgeByIdTest(){
        employeeService.updateAgeById(1,55);
    }

}
