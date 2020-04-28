package com.myimooc.java.sms.model;

/**
 * 学生实体类
 *
 * @author zc
 * @date 2018/05/29
 */
public class Student extends BaseNamedEntity {

    /**
     * 班级
     */
    private String group;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Student(String id, String name, String group) {
        super(id, name);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
