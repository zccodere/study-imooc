package com.myimooc.boot.start.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息<
 *
 * @author zc 2018-04-19
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7332961063564924222L;
    /**
     * 名称
     */
    private String name;
    /**
     * 密码，使用 @JsonIgnore 注解，在序列化为 JSON 时，忽略该字段
     */
    @JsonIgnore
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 生日，使用 @JsonFormat 注解，在序列化为 JSON 时，使用 pattern 属性指定的值格式化日期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date birthday;
    /**
     * 描述，使用 @JsonInclude 注解，在序列化为 JSON 时，当字段为 null 时，则忽略该字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", note='" + note + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
