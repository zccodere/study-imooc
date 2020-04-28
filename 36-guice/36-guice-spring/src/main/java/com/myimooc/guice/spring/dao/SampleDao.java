package com.myimooc.guice.spring.dao;

import org.springframework.stereotype.Component;

/**
 * Dao类；假定已经接入JPA
 *
 * @author zc 2017-10-15
 */
@Component
public class SampleDao {

    public void save(String data) {
        System.out.println(data + " saved.");
    }

    public String getPersonData(String name) {
        System.out.println("Getting person data for: " + name);
        return name;
    }
}
