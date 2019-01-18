package com.myimooc.spring.mvc.bind.model;

import java.util.Map;

/**
 * Created by ChengComputer on 2017/2/19.
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-19
 */
public class UserMapForm {

    private Map<String,User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserMapForm{" +
                "users=" + users +
                '}';
    }
}
