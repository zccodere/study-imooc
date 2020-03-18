package com.myimooc.small.advanced.domain.menu;

import java.util.Arrays;

/**
 * 菜单
 *
 * @author zc 2017-08-12
 */
public class Menu {

    private Button[] button;

    @Override
    public String toString() {
        return "Menu{" +
                "button=" + Arrays.toString(button) +
                '}';
    }

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }
}
