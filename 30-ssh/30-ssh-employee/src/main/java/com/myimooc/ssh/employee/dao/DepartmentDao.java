package com.myimooc.ssh.employee.dao;

import com.myimooc.ssh.employee.domain.Department;

import java.util.List;

/**
 * 部门管理的DAO的接口
 *
 * @author zc 2017-08-18
 */
public interface DepartmentDao {

    /**
     * 查询总数
     *
     * @return 总数
     */
    int findCount();

    /**
     * 分页查询
     *
     * @param begin    开始
     * @param pageSize 每页大小
     * @return 部门集合
     */
    List<Department> findByPage(int begin, int pageSize);

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
