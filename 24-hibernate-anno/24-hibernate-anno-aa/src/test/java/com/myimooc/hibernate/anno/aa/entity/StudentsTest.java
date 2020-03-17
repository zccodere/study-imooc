package com.myimooc.hibernate.anno.aa.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * 测试类
 *
 * @author zc 2017-07-12
 */
public class StudentsTest {

    private SessionFactory sessionFactory = null;

    @Before
    public void schemaExportTest() {
        // 创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        // 生成sessionFactory
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

//		SchemaExport export = new SchemaExport(config);
//		export.create(true, true);
    }

    @Test
    public void addStudents() {
        // 创建会话
        Session session = sessionFactory.getCurrentSession();
        // 创建事务
        Transaction tx = session.beginTransaction();

        // 创建一个学生对象
        Address address = new Address("700005", "湖北武当山", "18991167346");
//        Students s = new Students("S0000002", "张三丰", "男", new Date(), "太极拳", address);
//        session.save(s);

        tx.commit();
    }

    @Test
    public void addStudentsByPk() {
        // 创建会话
        Session session = sessionFactory.getCurrentSession();
        // 创建事务
        Transaction tx = session.beginTransaction();

        // 创建一个学生对象
        Address address = new Address("700005", "湖北武当山", "18991167346");
        // 创建学生主键对象
        StudentsPk pk = new StudentsPk();
        pk.setId("123456789012345678");
        pk.setSid("1235241231");

        Students s = new Students(pk, "张三丰", "男", new Date(), "太极拳", address);
        session.save(s);
        tx.commit();
    }
}
