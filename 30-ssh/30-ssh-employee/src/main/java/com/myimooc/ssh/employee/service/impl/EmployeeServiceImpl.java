package com.myimooc.ssh.employee.service.impl;

import com.myimooc.ssh.employee.dao.EmployeeDao;
import com.myimooc.ssh.employee.domain.Employee;
import com.myimooc.ssh.employee.domain.PageBean;
import com.myimooc.ssh.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工管理的业务层的实现类
 *
 * @author zc 2017-08-18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 业务层登录方法
     */
    @Override
    public Employee login(Employee employee) {
        return employeeDao.findByUsernameAndPassword(employee);
    }

    /**
     * 分页查询员工信息
     */
    @Override
    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<>();
        // 封装当前页数
        pageBean.setCurrPage(currPage);
        // 封装每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 封装总记录数
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 封装总页数
        double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage((int) num);
        // 封装每页显示数据
        int begin = (currPage - 1) * pageSize;
        List<Employee> list = employeeDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * 保存员工信息
     */
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);

    }

    @Override
    public Employee findById(Integer eid) {
        return employeeDao.findById(eid);
    }

    /**
     * 修改员工信息
     */
    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    /**
     * 删除员工信息
     */
    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}
