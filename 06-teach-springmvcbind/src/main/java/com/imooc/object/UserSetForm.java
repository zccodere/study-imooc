package com.imooc.object;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by geely on 2015/11/22.
 */
public class UserSetForm {
    private Set<User> users;

    private UserSetForm(){
        users = new LinkedHashSet<User>();
        users.add(new User());
        users.add(new User());
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserSetForm{" +
                "users=" + users +
                '}';
    }
}
