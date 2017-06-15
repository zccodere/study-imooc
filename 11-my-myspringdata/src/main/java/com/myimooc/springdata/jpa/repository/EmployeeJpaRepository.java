package com.myimooc.springdata.jpa.repository;

import com.myimooc.springdata.jpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 使用 JpaRepository 接口
 * Created by ZC on 2017/4/26.
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {
}
