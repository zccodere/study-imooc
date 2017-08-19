package com.myimooc.sshemployee.dao;

import java.util.List;

import com.myimooc.sshemployee.domain.Department;

/**
 * 部门管理的DAO的接口
 * @author ZhangCheng on 2017-08-18
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
