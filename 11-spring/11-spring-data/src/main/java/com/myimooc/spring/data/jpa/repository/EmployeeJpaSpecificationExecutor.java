package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <br>
 * 标题: 使用 JpaSpecificationExecutor 接口<br>
 * 描述: 使用 JpaSpecificationExecutor 接口<br>
 * 时间: 2017/04/26<br>
 *
 * @author zc
 */
public interface EmployeeJpaSpecificationExecutor extends JpaRepository<Employee,Integer> ,
        JpaSpecificationExecutor<Employee>{
}
