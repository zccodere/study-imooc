package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.AbstractTestSupport;
import com.myimooc.spring.data.jpa.domain.Employee;

import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * PagingAndSortingRepository 测试类
 *
 * @author zc 2017-04-26
 */
public class EmployeePagingAndSortingRepositoryTest extends AbstractTestSupport {

    /**
     * 分页功能测试
     */
    @Test
    public void pageTest() {
        EmployeePagingAndSortingRepository repository = ctx.getBean(EmployeePagingAndSortingRepository.class);

        // page: index是从0开始的，不是从1开始的
        Pageable pageable = PageRequest.of(0, 9);
        Page<Employee> employeePage = repository.findAll(pageable);

        System.out.println("查询的总页数：" + employeePage.getTotalPages());
        System.out.println("查询的总记录数：" + employeePage.getTotalElements());
        System.out.println("查询的当前第几页：" + (employeePage.getNumber() + 1));
        System.out.println("查询的当前页面的集合：" + employeePage.getContent());
        System.out.println("查询的当前页面的记录数：" + employeePage.getNumberOfElements());
    }

    /**
     * 分页和排序功能测试
     */
    @Test
    public void pageAndSort() {
        EmployeePagingAndSortingRepository repository = ctx.getBean(EmployeePagingAndSortingRepository.class);

        // 根据ID降序排序
        Sort sort = Sort.by("id").descending();
        // page: index是从0开始的，不是从1开始的
        Pageable pageable = PageRequest.of(0, 5, sort);
        Page<Employee> employeePage = repository.findAll(pageable);

        System.out.println("查询的总页数：" + employeePage.getTotalPages());
        System.out.println("查询的总记录数：" + employeePage.getTotalElements());
        System.out.println("查询的当前第几页：" + (employeePage.getNumber() + 1));
        System.out.println("查询的当前页面的集合：" + employeePage.getContent());
        System.out.println("查询的当前页面的记录数：" + employeePage.getNumberOfElements());
    }
}
