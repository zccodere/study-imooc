package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用 JpaRepository 接口
 *
 * @author zc 2017-04-26
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
