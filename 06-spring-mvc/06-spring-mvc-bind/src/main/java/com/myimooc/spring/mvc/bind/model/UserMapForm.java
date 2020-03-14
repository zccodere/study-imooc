package com.myimooc.spring.mvc.bind.model;

import java.util.Map;

/**
 * 用户集合表单实体类
 *
 * @author zc 2017-02-19
 */
public class UserMapForm {

    private Map<String, User> users;

    @Override
    public String toString() {
        return "UserMapForm{" +
                "users=" + users +
                '}';
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
