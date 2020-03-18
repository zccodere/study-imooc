package com.myimooc.ssh.employee.dao.impl;

import com.myimooc.ssh.employee.dao.EmployeeDao;
import com.myimooc.ssh.employee.domain.Employee;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * 员工管理的DAO的实现类
 *
 * @author zc 2017-08-18
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * DAO根据用户名和密码查询用户的方法
     */
    @Override
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql = "from Employee where username = ? and password = ?";
        @SuppressWarnings("unchecked")
        List<Employee> list = (List<Employee>) hibernateTemplate.find(hql, employee.getUsername(), employee.getPassword());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        list.removeAll(Collections.singleton(null));
        return null;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Employee";
        @SuppressWarnings("unchecked")
        List<Long> list = (List<Long>) hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Employee> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        @SuppressWarnings("unchecked")
        List<Employee> list = (List<Employee>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
        return list;
    }

    /**
     * DAO中保存员工信息
     */
    @Override
    public void save(Employee employee) {
        System.out.println("保存员工信息");
        hibernateTemplate.save(employee);
        System.out.println("保存信息成功");
    }

    /**
     * DAO中根据员工ID查询员工信息
     */
    @Override
    public Employee findById(Integer eid) {
        return hibernateTemplate.get(Employee.class, eid);
    }

    @Override
    public void update(Employee employee) {
        hibernateTemplate.update(employee);
    }


    @Override
    public void delete(Employee employee) {
        hibernateTemplate.delete(employee);
    }
}
