package com.myimooc.springdata.jpa.repository;

import com.myimooc.springdata.jpa.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 使用 PagingAndSortingRepository 实现分页和排序功能
 * Created by ZC on 2017/4/26.
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
