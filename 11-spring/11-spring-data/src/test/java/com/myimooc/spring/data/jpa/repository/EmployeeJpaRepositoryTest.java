package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.config.SpringConfig;
import com.myimooc.spring.data.jpa.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * PagingAndSortingRepository 单元测试类
 * Created by ZC on 2017/4/26.
 */
public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
    }

    @After
    public void destroy(){
        ctx = null;
    }

    @Test
    public void findTest(){
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println("employee"+employee.toString());

        System.out.println("employee(10)"+employeeJpaRepository.exists(10));
        System.out.println("employee(102)"+employeeJpaRepository.exists(102));


    }

}
