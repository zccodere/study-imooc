package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 使用 PagingAndSortingRepository 实现分页和排序功能
 *
 * @author zc 2017-04-26
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
