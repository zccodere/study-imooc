package com.myimooc.springdata.jpa.repository;

import com.myimooc.springdata.jpa.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * 使用 CrudRepository 接口
 * Created by ZC on 2017/4/26.
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer>{



}
