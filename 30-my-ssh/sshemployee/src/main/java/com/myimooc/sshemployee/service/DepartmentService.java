package com.myimooc.sshemployee.service;

import java.util.List;

import com.myimooc.sshemployee.domain.Department;
import com.myimooc.sshemployee.domain.PageBean;

/**
 * 部门管理的业务层的接口
 * @author ZhangCheng on 2017-08-18
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
