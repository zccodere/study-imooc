package com.myimooc.hibernate.anno.ca.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * 单元测试类
 * @author ZhangCheng on 2017-07-12
 *
 */
public class StudentsTest {
	
	@Test
	public void schemaExportTest(){
		// 创建hibernate配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry ServiceRegistry = new ServiceRegistryBuilder()
			.applySettings(config.getProperties()).buildServiceRegistry();
		// 生成sessionFactory
		@SuppressWarnings("unused")
		SessionFactory sessionFactory = config.buildSessionFactory(ServiceRegistry);
		
		SchemaExport export = new SchemaExport(config);
		
		export.create(true, true);
	}
	
}
