package com.myimooc.sshemployee.dao;

import java.util.List;

import com.myimooc.sshemployee.domain.Employee;

/**
 * 员工管理的DAO的接口
 * @author ZhangCheng on 2017-08-18
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
