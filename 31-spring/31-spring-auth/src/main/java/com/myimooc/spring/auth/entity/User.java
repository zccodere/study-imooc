package com.myimooc.spring.auth.entity;

import com.myimooc.spring.auth.common.BaseEntity;

/**
 * 用户实体类
 *
 * @author zc 2017-08-19
 */
public class User extends BaseEntity {

    private String name;
    private String pwd;

    @Override
    public String toString() {
        return super.toString() + "User [name=" + name + ", pwd=" + pwd + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
