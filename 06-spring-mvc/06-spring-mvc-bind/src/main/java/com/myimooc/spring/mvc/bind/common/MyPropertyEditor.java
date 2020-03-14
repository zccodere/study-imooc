package com.myimooc.spring.mvc.bind.common;


import com.myimooc.spring.mvc.bind.model.User;

import java.beans.PropertyEditorSupport;

/**
 * 自定义属性编辑器
 *
 * @author zc 2017-02-19
 */
public class MyPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User u = new User();
        String[] textArray = text.split(",");
        u.setName(textArray[0]);
        u.setAge(Integer.parseInt(textArray[1]));
        super.setValue(u);
    }

    public static void main(String[] args) {
        MyPropertyEditor editor = new MyPropertyEditor();
        editor.setAsText("tom,22");
        System.out.println(editor.getValue());
    }
}
