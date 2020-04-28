package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 使用 JpaSpecificationExecutor 接口
 *
 * @author zc 2017-04-26
 */
public interface EmployeeJpaSpecificationExecutor extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

}
