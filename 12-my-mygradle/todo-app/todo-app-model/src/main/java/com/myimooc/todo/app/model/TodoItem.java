package com.myimooc.todo.app.model;

/**
 * Created by ZC on 2017/5/16.
 */
public class TodoItem {
    // 待办事项名称
    private String name;
    // 已完成
    private boolean hasDone;

    public TodoItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDone() {
        return hasDone;
    }

    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }

    @Override
    public String toString() {
        return name + " need todo";
    }
}
