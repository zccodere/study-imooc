package com.myimooc.json.simple.model;

import java.util.Arrays;

/**
 * 人物实体类
 *
 * @author zc 2017-05-21
 */
public class Person {

    private String name;
    private String school;
    private Boolean hasGirlfriend;
    private Double age;
    private Object car;
    private Object house;
    private String[] major;
    private String comment;
    private String birthday;
    /**
     * 使用 transient 关键字，生成 JSON 时忽略该字段
     */
    private transient String ignore;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", hasGirlfriend=" + hasGirlfriend +
                ", age=" + age +
                ", car=" + car +
                ", house=" + house +
                ", major=" + Arrays.toString(major) +
                ", comment='" + comment + '\'' +
                ", birthday='" + birthday + '\'' +
                ", ignore='" + ignore + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Boolean getHasGirlfriend() {
        return hasGirlfriend;
    }

    public void setHasGirlfriend(Boolean hasGirlfriend) {
        this.hasGirlfriend = hasGirlfriend;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Object getCar() {
        return car;
    }

    public void setCar(Object car) {
        this.car = car;
    }

    public Object getHouse() {
        return house;
    }

    public void setHouse(Object house) {
        this.house = house;
    }

    public String[] getMajor() {
        return major;
    }

    public void setMajor(String[] major) {
        this.major = major;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
}
