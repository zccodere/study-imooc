package com.myimooc.ssh.employee.dao.impl;

import com.myimooc.ssh.employee.dao.DepartmentDao;
import com.myimooc.ssh.employee.domain.Department;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门管理的DAO的实现类
 *
 * @author zc 2017-08-18
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int findCount() {
        String hql = "select count(*) from Department";
        @SuppressWarnings("unchecked")
        List<Long> list = (List<Long>) hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    /**
     * 分页查询部门
     */
    @Override
    public List<Department> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        @SuppressWarnings("unchecked")
        List<Department> list = (List<Department>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
        return list;
    }

    /**
     * 添加部门
     */
    @Override
    public void save(Department department) {
        hibernateTemplate.save(department);
    }

    /**
     * 根据部门的ID查询部门
     */
    @Override
    public Department findById(Integer did) {
        return hibernateTemplate.get(Department.class, did);
    }

    /**
     * 修改部门
     */
    @Override
    public void update(Department department) {
        hibernateTemplate.update(department);
    }

    /**
     * 删除部门
     */
    @Override
    public void delete(Department department) {
        hibernateTemplate.delete(department);

    }

    /**
     * 查询所有部门
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Department> findAll() {
        return (List<Department>) hibernateTemplate.find("from Department");
    }
}
