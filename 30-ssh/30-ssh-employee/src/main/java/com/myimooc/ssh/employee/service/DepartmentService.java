package com.myimooc.ssh.employee.service;

import com.myimooc.ssh.employee.domain.Department;
import com.myimooc.ssh.employee.domain.PageBean;

import java.util.List;

/**
 * 部门管理的业务层的接口
 *
 * @author zc 2017-08-18
 */
public interface DepartmentService {

    /**
     * 分页查询
     *
     * @param currPage 当前页
     * @return 部门集合
     */
    PageBean<Department> findByPage(Integer currPage);

    /**
     * 保存
     *
     * @param department 部门
     */
    void save(Department department);

    /**
     * 查询
     *
     * @param did 部门ID
     * @return 部门
     */
    Department findById(Integer did);

    /**
     * 更新
     *
     * @param department 部门
     */
    void update(Department department);

    /**
     * 删除
     *
     * @param department 部门
     */
    void delete(Department department);

    /**
     * 查询全部
     *
     * @return 部门集合
     */
    List<Department> findAll();

}
