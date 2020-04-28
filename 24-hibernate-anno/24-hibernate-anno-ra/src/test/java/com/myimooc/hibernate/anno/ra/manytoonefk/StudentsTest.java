package com.myimooc.hibernate.anno.ra.manytoonefk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.EnumSet;

/**
 * 多对一单向外键关联； 单元测试类
 *
 * @author zc 2017-07-13
 */
public class StudentsTest {

    private SessionFactory sessionFactory = null;

    @Before
    public void schemaExportTest() {
        // 创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        // 构建元数据
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        // 构建会话工厂
        sessionFactory = metadata.buildSessionFactory();

        SchemaExport export = new SchemaExport();
        export.create(EnumSet.of(TargetType.DATABASE), metadata);
    }

    @Test
    public void addStudents() {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // 创建班级对象
        ClassRoom c1 = new ClassRoom("C001", "软件工程");
        ClassRoom c2 = new ClassRoom("C002", "网络工程");
        // 创建学生对象
        Students s1 = new Students("张三", "男", new Date(), "计算机");
        Students s2 = new Students("李四", "男", new Date(), "计算机");
        Students s3 = new Students("王五", "女", new Date(), "计算机");
        Students s4 = new Students("赵六", "女", new Date(), "计算机");

        s1.setClassRoom(c1);
        s2.setClassRoom(c1);
        s3.setClassRoom(c2);
        s4.setClassRoom(c2);

        // 先保存班级
        session.save(c1);
        session.save(c2);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);

        tx.commit();

    }
}
