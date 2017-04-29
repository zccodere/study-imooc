package com.myimooc.springdata.jpa.repository;

import com.myimooc.springdata.jpa.config.SpringConfig;
import com.myimooc.springdata.jpa.domain.Employee;
import com.myimooc.springdata.jpa.repository.EmployeeJpaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

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
