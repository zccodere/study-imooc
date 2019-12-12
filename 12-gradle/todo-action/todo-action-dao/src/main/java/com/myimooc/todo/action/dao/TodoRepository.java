package com.myimooc.todo.action.dao;

import com.myimooc.todo.action.model.TodoItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChangComputer on 2017/5/20.
 */
public class TodoRepository {

    private static Map<String,TodoItem> items = new HashMap<String,TodoItem>();

    /**
     * 保存代办事项
     * @param item
     */
    public void save(TodoItem item){
        items.put(item.getName(),item);
    }

    /**
     * 获取代办事项
     * @param name
     * @return
     */
    public TodoItem query(String name){
        return items.get(name);
    }

}
