package com.myimooc.hibernate.anno.ra.manytomanybfk;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Before;
import org.junit.Test;

/**
 * 多对多双向外键关联
 * 单元测试类
 * @author ZhangCheng on 2017-07-13
 *
 */
public class StudentsTest {
	
	private SessionFactory sessionFactory = null;
	
	@Before
	//@Test
	public void schemaExportTest(){
		// 创建hibernate配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry ServiceRegistry = new ServiceRegistryBuilder()
			.applySettings(config.getProperties()).buildServiceRegistry();
		// 生成sessionFactory
		sessionFactory = config.buildSessionFactory(ServiceRegistry);
		
		SchemaExport export = new SchemaExport(config);
		
		export.create(true, true);
	}
	
	@Test
	public void addStudents(){
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 创建教师对象
		Teachers t1 = new Teachers("T001","张老师");
		Teachers t2 = new Teachers("T002","李老师");
		Teachers t3 = new Teachers("T003","陈老师");
		Teachers t4 = new Teachers("T004","刘老师");
		
		// 创建学生对象
		Students s1 = new Students("张三","男",new Date(),"计算机");
		Students s2 = new Students("李四","男",new Date(),"计算机");
		Students s3 = new Students("王五","女",new Date(),"计算机");
		Students s4 = new Students("赵六","女",new Date(),"计算机");
		
		// 创建教师集合
		Set<Teachers> set1 = new HashSet<Teachers>();
		set1.add(t1);
		set1.add(t2);
		Set<Teachers> set2 = new HashSet<Teachers>();
		set2.add(t3);
		set2.add(t4);
		Set<Teachers> set3 = new HashSet<Teachers>();
		set3.add(t1);
		set3.add(t3);
		set3.add(t4);
		Set<Teachers> set4 = new HashSet<Teachers>();
		set4.add(t2);
		set4.add(t3);
		set4.add(t4);
		
		// 设置学生教师
		s1.setTeachers(set1);
		s2.setTeachers(set2);
		s3.setTeachers(set3);
		s4.setTeachers(set4);
		
		// 保存教师信息
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		
		// 保存学生信息
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		tx.commit();
		
	}
	
}
