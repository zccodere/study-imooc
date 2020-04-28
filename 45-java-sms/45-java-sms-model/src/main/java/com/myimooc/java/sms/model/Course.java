package com.myimooc.java.sms.model;

/**
 * 班级实体类
 *
 * @author zc
 * @date 2018/05/29
 */
public class Course extends BaseNamedEntity {

    public Course() {
    }

    public Course(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
