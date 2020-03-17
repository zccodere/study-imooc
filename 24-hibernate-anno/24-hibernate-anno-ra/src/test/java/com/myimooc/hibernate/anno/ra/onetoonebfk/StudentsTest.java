package com.myimooc.hibernate.anno.ra.onetoonebfk;

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
 * 一对一双向外键关联； 单元测试类
 *
 * @author zc 2017-07-12
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

    /**
     * 一对一双向外键关联保存测试
     */
    @Test
    public void addStudents() {

        Session session = sessionFactory.getCurrentSession();

        // 生成一个身份证对象
        IdCard card = new IdCard("123456789012345678", "张无忌");
        Transaction tx = session.beginTransaction();
        // 生成学生对象
        Students s = new Students(card, "男", new Date(), "太极拳");
        // 先保存身份证类的对象
        session.save(card);
        session.save(s);

        tx.commit();

    }

}
