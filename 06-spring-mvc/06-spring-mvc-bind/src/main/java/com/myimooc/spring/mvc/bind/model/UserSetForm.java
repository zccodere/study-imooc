package com.myimooc.spring.mvc.bind.model;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 用户Set表单实体类
 *
 * @author zc 2017-02-19
 */
public class UserSetForm {

    private Set<User> users;

    private UserSetForm() {
        users = new LinkedHashSet<>();
        users.add(new User());
        users.add(new User());
    }

    @Override
    public String toString() {
        return "UserSetForm{" +
                "users=" + users +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
