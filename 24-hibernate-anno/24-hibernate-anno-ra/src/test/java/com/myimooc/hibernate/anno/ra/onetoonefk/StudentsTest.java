package com.myimooc.hibernate.anno.ra.onetoonefk;

import java.util.Date;

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
 * 一对一双单外键关联
 * 单元测试类
 * @author ZhangCheng on 2017-07-12
 *
 */
@SuppressWarnings("unused")
public class StudentsTest {
	
	private SessionFactory sessionFactory = null;
	
	@Before
	public void schemaExportTest(){
		// 创建hibernate配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry ServiceRegistry = new ServiceRegistryBuilder()
			.applySettings(config.getProperties()).buildServiceRegistry();
		// 生成sessionFactory
		sessionFactory = config.buildSessionFactory(ServiceRegistry);
		
//		SchemaExport export = new SchemaExport(config);
//		
//		export.create(true, true);
	}
	
	/**
	 * 一对一单向外键关联保存测试
	 */
	@Test
	public void addStudents(){
		
		Session session = sessionFactory.getCurrentSession();
		
		// 生成一个身份证对象
		IdCard card = new IdCard("123456789012345678","张无忌");
		Transaction tx = session.beginTransaction();
		// 生成学生对象
		Students s = new Students(card, "男", new Date(), "太极拳");
		// 先保存身份证类的对象
		session.save(card);
		session.save(s);
		
		tx.commit();
		
	}
	
}
