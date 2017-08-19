package com.myimooc.sshemployee.service;

import com.myimooc.sshemployee.domain.Employee;
import com.myimooc.sshemployee.domain.PageBean;

/**
 * 员工管理的业务层的接口
 * @author ZhangCheng on 2017-08-18
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
