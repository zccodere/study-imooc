package com.myimooc.boot.start.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 从配置文件中获取属性值
 *
 * @author zc 2018-04-25
 */
@Configuration
@ConfigurationProperties(prefix = "com.imooc.opensource")
@PropertySource(value = "classpath:resource.properties")
public class Resource {

    private String name;

    private String website;

    private String language;

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
