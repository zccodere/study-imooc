package com.myimooc.todo.action.dao;

import com.myimooc.todo.action.model.TodoItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChangComputer on 2017/5/20.
 */
public class TodoRepositoryTest {

    private TodoRepository repository = new TodoRepository();

    @Test
    public void saveTest(){
        TodoItem todoItem = new TodoItem("imooc");
        repository.save(todoItem);

        Assert.assertNull(repository.query(todoItem.getName()));
//        Assert.assertNotNull(repository.query(todoItem.getName()));
    }

}
