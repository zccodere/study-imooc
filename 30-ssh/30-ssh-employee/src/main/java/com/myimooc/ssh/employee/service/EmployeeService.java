package com.myimooc.ssh.employee.service;

import com.myimooc.ssh.employee.domain.Employee;
import com.myimooc.ssh.employee.domain.PageBean;

/**
 * 员工管理的业务层的接口
 *
 * @author zc 2017-08-18
 */
public interface EmployeeService {

    /**
     * 登录
     *
     * @param employee 员工
     * @return 员工
     */
    Employee login(Employee employee);

    /**
     * 查找
     *
     * @param currPage 当前页
     * @return 员工集合
     */
    PageBean<Employee> findByPage(Integer currPage);

    /**
     * 保存
     *
     * @param employee 员工
     */
    void save(Employee employee);

    /**
     * 查找
     *
     * @param eid 员工ID
     * @return 员工
     */
    Employee findById(Integer eid);

    /**
     * 更新
     *
     * @param employee 员工
     */
    void update(Employee employee);

    /**
     * 员工
     *
     * @param employee 员工
     */
    void delete(Employee employee);

}
