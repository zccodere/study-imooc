package com.myimooc.springdata.jpa.repository;

import com.myimooc.springdata.jpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 使用 JpaSpecificationExecutor 接口
 * Created by ZC on 2017/4/26.
 */
public interface EmployeeJpaSpecificationExecutor extends JpaRepository<Employee,Integer> ,
        JpaSpecificationExecutor<Employee>{
}
