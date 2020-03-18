package com.myimooc.small.advanced.domain.menu;

/**
 * 视图按钮
 *
 * @author zc 2017-08-12
 */
public class ViewButton extends Button {

    private String url;

    @Override
    public String toString() {
        return super.toString() + "ViewButton{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
