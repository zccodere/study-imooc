package com.myimooc.hibernate.mtm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * session会话工具类
 *
 * @author zc 2017-07-11
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        // 5.X版本，通过如下构建 SessionFactory
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    }

    /**
     * 获取SessionFactory
     */
    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 获取Session
     */
    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    /**
     * 关闭Session
     */
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}
