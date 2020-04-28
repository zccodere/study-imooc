package com.myimooc.small.advanced.domain.menu;

/**
 * 点击按钮
 *
 * @author zc 2017-08-12
 */
public class ClickButton extends Button {

    private String key;

    @Override
    public String toString() {
        return super.toString() + "ClickButton{" +
                "key='" + key + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
