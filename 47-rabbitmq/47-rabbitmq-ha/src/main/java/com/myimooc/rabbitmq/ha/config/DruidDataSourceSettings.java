package com.myimooc.rabbitmq.ha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * <br>
 * 标题: Druid数据源配置<br>
 * 描述: Druid数据源配置<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@Component
@PropertySource("classpath:druid.properties")
public class DruidDataSourceSettings {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Value("${druid.initialSize}")
    private Integer initialSize;
    @Value("${druid.minIdle}")
    private Integer minIdle;
    @Value("${druid.maxActive}")
    private Integer maxActive;
    @Value("${druid.maxWait}")
    private Long maxWait;

    @Value("${druid.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;

    @Value("${druid.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;
    @Value("${druid.validationQuery}")
    private String validationQuery;
    @Value("${druid.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${druid.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${druid.testOnReturn}")
    private Boolean testOnReturn;

    @Value("${druid.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${druid.maxOpenPreparedStatements}")
    private Integer maxOpenPreparedStatements;

    @Value("${druid.filters}")
    private String filters;
    @Value("${druid.connectionProperties}")
    private String connectionProperties;
    @Value("${druid.useGlobalDataSourceStat}")
    private Boolean useGlobalDataSourceStat;

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public Long getMaxWait() {
        return maxWait;
    }

    public Long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public Long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public Boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public Integer getMaxOpenPreparedStatements() {
        return maxOpenPreparedStatements;
    }

    public String getFilters() {
        return filters;
    }

    public Properties getConnectionProperties() {
        Properties properties = new Properties();
        String[] entrys = connectionProperties.split(";");
        for (String entry : entrys) {
            String[] split = entry.split("=");
            properties.setProperty(split[0],split[1]);
        }
        return properties;
    }

    public Boolean getUseGlobalDataSourceStat() {
        return useGlobalDataSourceStat;
    }
}
