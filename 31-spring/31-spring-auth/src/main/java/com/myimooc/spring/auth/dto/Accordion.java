package com.myimooc.spring.auth.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * Accordion
 *
 * @author zc 2017-08-19
 */
public class Accordion implements Comparable<Accordion> {

    private Long id;
    private Long parentId;
    private String name;
    private String url;
    private List<Accordion> children = new LinkedList<>();
    private Integer order;


    public Accordion() {
    }

    public Accordion(Long id, Long parentId, String name, String url, Integer order) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Accordion [id=" + id + ", parentId=" + parentId + ", name=" + name + ", url=" + url + ", children="
                + children + ", order=" + order + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Accordion> getChildren() {
        return children;
    }

    public void setChildren(List<Accordion> children) {
        this.children = children;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(Accordion o) {
        return this.getOrder() - o.getOrder();
    }
}
