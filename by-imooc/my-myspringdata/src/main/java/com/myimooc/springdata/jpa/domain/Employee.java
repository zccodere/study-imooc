package com.myimooc.springdata.jpa.domain;

import javax.persistence.*;

/**
 * 雇员：先开发实体类，然后自动生成实体表
 * Created by ZC on 2017/4/24.
 */
@Entity
@Table(name = "test_employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 20)
    private String name;

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
