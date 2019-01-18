package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.config.SpringConfig;
import com.myimooc.spring.data.jpa.domain.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * PagingAndSortingRepository 单元测试类
 * Created by ZC on 2017/4/26.
 */
public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
    }

    @After
    public void destroy(){
        ctx = null;
    }

    /**
     * 分页功能测试
     */
    @Test
    public void pageTest(){
        // page: index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0,9);
        Page<Employee> employeePage = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询的总页数："+employeePage.getTotalPages());
        System.out.println("查询的总记录数："+employeePage.getTotalElements());
        System.out.println("查询的当前第几页："+(employeePage.getNumber() + 1));
        System.out.println("查询的当前页面的集合："+employeePage.getContent());
        System.out.println("查询的当前页面的记录数："+employeePage.getNumberOfElements());

    }

    /**
     * 分页和排序功能测试
     */
    @Test
    public void pageAndSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort = new Sort(order);
        // page: index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> employeePage = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询的总页数："+employeePage.getTotalPages());
        System.out.println("查询的总记录数："+employeePage.getTotalElements());
        System.out.println("查询的当前第几页："+(employeePage.getNumber() + 1));
        System.out.println("查询的当前页面的集合："+employeePage.getContent());
        System.out.println("查询的当前页面的记录数："+employeePage.getNumberOfElements());
    }

}
