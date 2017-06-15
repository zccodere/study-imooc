package com.myimooc.springdata.jpa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZC on 2017/4/24.
 */
@PropertySource(value="classpath:db.properties")
@Component
public class PropertiesConfig {
    @Value("${jdbc.driverClass}")
    private String jdbcDriverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Override
    public String toString() {
        return "Properties{" +
                "jdbcDriverClass='" + jdbcDriverClass + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", jdbcUser='" + jdbcUser + '\'' +
                ", jdbcPassword='" + jdbcPassword + '\'' +
                '}';
    }

    public String getJdbcDriverClass() {
        return jdbcDriverClass;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }
}
