package com.myimooc.spring.aop.guide.domain;

import java.io.Serializable;

/**
 * 产品实体对象
 *
 * @author zc 2017-09-03
 */
public class Product implements Serializable {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
