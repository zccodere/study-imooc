package com.myimooc.ssh.employee.dao;

import java.util.List;

import com.myimooc.ssh.employee.domain.Employee;

/**
 * 员工管理的DAO的接口
 *
 * @author ZhangCheng on 2017-08-18
 */
public interface EmployeeDao {
    /**
     * 通过用户名和密码查询
     *
     * @param employee 员工
     * @return 员工
     */
    Employee findByUsernameAndPassword(Employee employee);

    /**
     * 查询总数
     *
     * @return
     */
    int findCount();

    /**
     * 分页查询
     *
     * @param begin    开始
     * @param pageSize 每页大小
     * @return 员工集合
     */
    List<Employee> findByPage(int begin, int pageSize);

    /**
     * 保存
     *
     * @param employee 员工
     */
    void save(Employee employee);

    /**
     * 查询
     *
     * @param eid 员工ID
     * @return 员工
     */
    Employee findById(Integer eid);

    /**
     * 删除
     *
     * @param employee 员工
     */
    void update(Employee employee);

    /**
     * 删除
     *
     * @param employee 员工
     */
    void delete(Employee employee);

}
