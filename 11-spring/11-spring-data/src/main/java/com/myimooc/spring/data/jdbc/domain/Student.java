package com.myimooc.spring.data.jdbc.domain;

/**
 * Student实体类
 *
 * @author zc 2017-04-24
 */
public class Student {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
