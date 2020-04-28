package com.myimooc.freemarker.simple.entity;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author zc 2017-03-19
 */
public class User {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户生日
     */
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
