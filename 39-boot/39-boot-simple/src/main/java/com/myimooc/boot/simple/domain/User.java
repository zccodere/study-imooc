package com.myimooc.boot.simple.domain;

import java.io.Serializable;

/**
 * 用户模型
 *
 * @author zc 2018-04-08
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7564986345486454458L;

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
