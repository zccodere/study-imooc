package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <br>
 * 标题: 使用 JpaRepository 接口<br>
 * 描述: 使用 JpaRepository 接口<br>
 * 时间: 2017/04/26<br>
 *
 * @author zc
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
