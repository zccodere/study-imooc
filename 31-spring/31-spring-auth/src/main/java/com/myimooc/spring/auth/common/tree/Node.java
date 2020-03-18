package com.myimooc.spring.auth.common.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * EasyUI展现树形结构节点对象
 *
 * @author zc 2017-08-19
 */
public class Node {

    private Long id;
    private Long parentId;
    private String text;
    private String state;
    private NodeAttribute attributes;
    private List<Node> children = new LinkedList<>();
    private Integer order;

    public Node() {
    }

    public Node(Long id, Long parentId, String text, String state, NodeAttribute attributes, Integer order) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.state = state;
        this.attributes = attributes;
        this.order = order;
    }

    public Node(Long id, Long parentId, String text, String state, NodeAttribute attributes, List<Node> children,
                Integer order) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.state = state;
        this.attributes = attributes;
        this.children = children;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Node [id=" + id + ", parentId=" + parentId + ", text=" + text + ", state=" + state + ", attributes="
                + attributes + ", children=" + children + ", order=" + order + "]";
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public NodeAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(NodeAttribute attributes) {
        this.attributes = attributes;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }


}
