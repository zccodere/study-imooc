package com.myimooc.hibernate.mtm.test;

import com.myimooc.hibernate.mtm.entity.Employee;
import com.myimooc.hibernate.mtm.entity.Project;
import com.myimooc.hibernate.mtm.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * 多对多关联关系的配置 同时建立了Project和Employee之间的双向多对多关联关系 关联关系的维护交由Project方来处理，并且在保存Project对象时会一并保存Employee对象
 *
 * @author zc 2017-07-11
 */
public class Test {

    public static void main(String[] args) {
        Project project1 = new Project(1001, "项目一");
        Project project2 = new Project(1002, "项目二");
        Employee employee1 = new Employee(1, "慕女神");
        Employee employee2 = new Employee(2, "imooc");

        // 参加项目1的员工有慕女神和imooc
        Set<Employee> projectEmployee1 = new HashSet<>(16);
        projectEmployee1.add(employee1);
        projectEmployee1.add(employee2);
        project1.setEmployees(projectEmployee1);

        // 参加项目2的员工有慕女神
        Set<Employee> projectEmployee2 = new HashSet<>(16);
        projectEmployee2.add(employee1);
        project2.setEmployees(projectEmployee2);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(project1);
        session.save(project2);
        tx.commit();
        HibernateUtil.closeSession(session);
    }
}
