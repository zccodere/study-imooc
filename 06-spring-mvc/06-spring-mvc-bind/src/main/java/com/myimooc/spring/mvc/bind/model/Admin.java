package com.myimooc.spring.mvc.bind.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 管理员实体类
 *
 * @author zc 2020-03-14
 */
@JacksonXmlRootElement(localName = "admin")
public class Admin {

    /**
     * 名称
     */
    @JacksonXmlProperty(localName = "name")
    private String name;
    /**
     * 年龄
     */
    @JacksonXmlProperty(localName = "age")
    private Integer age;

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
