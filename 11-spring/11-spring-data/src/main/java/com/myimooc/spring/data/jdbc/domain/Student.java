package com.myimooc.spring.data.jdbc.domain;

/**
 * <br>
 * 标题: Student实体类<br>
 * 描述: Student实体类<br>
 * 时间: 2017/04/24<br>
 *
 * @author zc
 */
public class Student {
    /** 主键ID */
    private Integer id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
