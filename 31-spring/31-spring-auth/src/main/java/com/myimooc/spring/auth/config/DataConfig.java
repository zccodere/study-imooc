package com.myimooc.spring.auth.config;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据源配置
 * @author zc on 2017-08-19
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataConfig {
	@Value("${jdbc.driverClass}")
	private String driverClass;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.user}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean("dataSouce")
	public ComboPooledDataSource dataSouce(){
		ComboPooledDataSource dataSouce= new ComboPooledDataSource();
		
		try {
			dataSouce.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSouce.setJdbcUrl(jdbcUrl);
		dataSouce.setUser(user);
		dataSouce.setPassword(password);
		return dataSouce;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSouce());
		return jdbcTemplate;
	}
	
	@Bean("transactionManager")
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSouce());
		return transactionManager;
	}
}
