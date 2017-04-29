package com.myimooc.springdata.jdbctemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by ZC on 2017/4/24.
 */
@Configuration
@ComponentScan("com.myimooc.springdata.jdbctemplate")
public class SpringConfig {

    @Autowired
    private Properties properties;

    @Bean
    DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(properties.getJdbcDriverClass());
        driverManagerDataSource.setUrl(properties.getJdbcUrl());
        driverManagerDataSource.setUsername(properties.getJdbcUser());
        driverManagerDataSource.setPassword(properties.getJdbcPassword());
        return driverManagerDataSource;
    }

    @Bean
    JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDriverManagerDataSource());
        return jdbcTemplate;
    }
}
