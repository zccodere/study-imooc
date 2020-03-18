package com.myimooc.spring.auth.entity;

import com.myimooc.spring.auth.common.BaseEntity;

/**
 * 菜单功能实体类
 *
 * @author zc 2017-08-19
 */
public class Function extends BaseEntity {

    private String name;
    private Long parentId;
    private String url;
    private Integer serialNum;
    private Integer accordion;

    @Override
    public String toString() {
        return super.toString() + "Function [name=" + name + ", parentId=" + parentId + ", url=" + url + ", serialNum=" + serialNum
                + ", accordion=" + accordion + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getAccordion() {
        return accordion;
    }

    public void setAccordion(Integer accordion) {
        this.accordion = accordion;
    }
}
