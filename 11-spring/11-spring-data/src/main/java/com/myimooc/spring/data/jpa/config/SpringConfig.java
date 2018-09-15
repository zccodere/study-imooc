package com.myimooc.spring.data.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * <br>
 * 标题: Spring配置类<br>
 * 描述: Spring配置类<br>
 * 时间: 2017/04/24<br>
 * // 声明为配置类
 * // @Configuration
 * // 启用事务管理
 * // @EnableTransactionManagement
 * // 启用自动扫描继承 JpaRepository 接口的类。
 * // 注意，此注解需要配置 entityManagerFactory 和 transactionManager
 * // 方式一：定义获取Bean方法名为 entityManagerFactory 和 transactionManager
 * // 方式二：配置 @EnableJpaRepositories注解的 entityManagerFactoryRef 属性 为自定义获取Bean的方法名。
 * // @EnableJpaRepositories(basePackages = "com.myimooc.spring.data.jpa")
 * // 启动对@AspectJ（面向切面）注解的支持
 * // @EnableAspectJAutoProxy
 * // 启用自动扫描 @Component 注解的Bean
 * // @ComponentScan(basePackages = "com.myimooc.spring.data.jpa")
 *
 *
 *
 *
 *
 * @author zc
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.myimooc.spring.data.jpa")
@ComponentScan(basePackages = "com.myimooc.spring.data.jpa")
public class SpringConfig{

    @Autowired
    private PropertiesConfig propertiesConfig;

    /**
     * 配置数据源
     * @return
     */
    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(propertiesConfig.getJdbcDriverClass());
        driverManagerDataSource.setUrl(propertiesConfig.getJdbcUrl());
        driverManagerDataSource.setUsername(propertiesConfig.getJdbcUser());
        driverManagerDataSource.setPassword(propertiesConfig.getJdbcPassword());
        return driverManagerDataSource;
    }


    /**
     * 配置事务管理器 JpaTransactionManager
     * @return
     */
    @Bean(name="transactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(this.dataSource());
        transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return transactionManager;
//        return new DataSourceTransactionManager(this.dataSource());
//        return new JpaTransactionManager(this.entityManagerFactory().getObject());
    }

    /**
     * 配置JPA的 EntityManagerFactory
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);

        entityManagerFactory.setPackagesToScan("com.myimooc.spring.data.jpa");

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        jpaProperties.setProperty("hibernate.show_sql","true");
        jpaProperties.setProperty("hibernate.format_sql","true");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto","update");

        entityManagerFactory.setJpaProperties(jpaProperties);

        return entityManagerFactory;
    }

}
