package com.myimooc.spring.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 雇员实体类
 *
 * @author zc 2017-04-24
 */
@Entity
@Table(name = "test_employee")
public class Employee {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 姓名
     */
    @Column(length = 20)
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    @Override
    public String toString() {
        return "Employee{" +
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
