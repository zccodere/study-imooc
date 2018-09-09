package com.myimooc.java.sms.model;
/**
 * <br>
 * 标题: POJO基类<br>
 * 描述: 领域模型对象基类<br>
 *
 * @author zc
 * @date 2018/05/29
 */
public abstract class BaseEntity {

    protected String id;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
