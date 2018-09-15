package com.myimooc.spring.data.jpa.domain;

import javax.persistence.*;

/**
 * <br>
 * 标题: 雇员实体类<br>
 * 描述: 雇员实体类<br>
 * 时间: 2017/04/24<br>
 *
 * @author zc
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
