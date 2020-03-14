package com.myimooc.spring.mvc.bind.model;

import java.util.List;

/**
 * 用户列表表单实体类
 *
 * @author zc 2017-02-19
 */
public class UserListForm {

    private List<User> users;

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
