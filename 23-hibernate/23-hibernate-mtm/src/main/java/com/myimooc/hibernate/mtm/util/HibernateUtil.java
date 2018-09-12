package com.myimooc.hibernate.mtm.util;

/**
 * session会话工具类
 * @author ZhangCheng on 2017-07-11
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static Session session;

	static {
		// 创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		StandardServiceRegistry ssr=ssrb.build();
		sessionFactory=config.buildSessionFactory(ssr);
	}
	
	/**
	 * 获取SessionFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	/**
	 * 获取Session
	 * @return
	 */
	public static Session getSession(){
		session=sessionFactory.openSession();
		return session;
	}
	
	/**
	 * 关闭Session
	 * @param session
	 */
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
}
