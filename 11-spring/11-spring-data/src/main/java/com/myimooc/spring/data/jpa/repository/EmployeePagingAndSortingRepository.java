package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <br>
 * 标题: 使用 PagingAndSortingRepository 实现分页和排序功能<br>
 * 描述: 使用 PagingAndSortingRepository 实现分页和排序功能<br>
 * 时间: 2017/04/26<br>
 *
 * @author zc
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
