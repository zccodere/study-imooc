package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;

import org.springframework.data.repository.CrudRepository;

/**
 * 使用 CrudRepository 接口
 *
 * @author zc 2017-04-26
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
