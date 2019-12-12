package com.myimooc.spring.mvc.bind.model;

import java.util.List;

/**
 * Created by ChengComputer on 2017/2/19.
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-19
 */
public class UserListForm {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }
}
