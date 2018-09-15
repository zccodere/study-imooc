package com.myimooc.json.simple.model;

import java.util.Date;
import java.util.List;

/**
 * <br>
 * 标题: 生日信息<br>
 * 描述: 生日信息<br>
 * 时间: 2017/05/21<br>
 *
 * @author zc
 */
public class DiaosiWithBirthday {
    private String name;
    private String school;
    private boolean hasGirlfriend;
    private double age;
    private Object car;
    private Object house;
    /**
     * 替换为集合类
     */
    private List<String> major;
    private String comment;
    private Date birthday;
    /**
     * 使用 transient 关键字，生成 JSON 时忽略该字段
     */
    private transient String ignore;

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
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

    public boolean isHasGirlfriend() {
        return hasGirlfriend;
    }

    public void setHasGirlfriend(boolean hasGirlfriend) {
        this.hasGirlfriend = hasGirlfriend;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
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

    public List<String> getMajor() {
        return major;
    }

    public void setMajor(List<String> major) {
        this.major = major;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "DiaosiWithBirthday{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", hasGirlfriend=" + hasGirlfriend +
                ", age=" + age +
                ", car=" + car +
                ", house=" + house +
                ", major=" + major +
                ", comment='" + comment + '\'' +
                ", birthday=" + birthday +
                ", ignore='" + ignore + '\'' +
                '}';
    }
}
