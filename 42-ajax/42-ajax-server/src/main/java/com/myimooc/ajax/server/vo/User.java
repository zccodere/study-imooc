package com.myimooc.ajax.server.vo;

import java.io.Serializable;

/**
 * 测试JSON格式请求测试入参
 *
 * @author zc 2018-04-18
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7125165180826055817L;

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
