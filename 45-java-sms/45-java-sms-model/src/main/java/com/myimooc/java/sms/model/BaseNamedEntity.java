package com.myimooc.java.sms.model;

/**
 * 包含名称的实体类
 *
 * @author zc
 * @date 2018/05/29
 */
public abstract class BaseNamedEntity extends BaseEntity {

    protected String name;

    public BaseNamedEntity() {
    }

    public BaseNamedEntity(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
