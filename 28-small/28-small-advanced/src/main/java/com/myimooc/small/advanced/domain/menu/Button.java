package com.myimooc.small.advanced.domain.menu;

/**
 * 菜单按钮
 *
 * @author ZhangCheng on 2017-08-12
 */
public class Button {
    private String type;
    private String name;
    private Button[] subButton;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button[] getSubButton() {
        return subButton;
    }

    public void setSubButton(Button[] subButton) {
        this.subButton = subButton;
    }
}
