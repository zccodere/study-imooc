package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * <br>
 * 标题: 使用 CrudRepository 接口<br>
 * 描述: 使用 CrudRepository 接口<br>
 * 时间: 2017/04/26<br>
 *
 * @author zc
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer>{



}
