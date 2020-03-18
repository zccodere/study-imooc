package com.myimooc.small.advanced.domain;

/**
 * 消息回复
 *
 * @author zc 2017-08-12
 */
public class News {

    private String title;
    private String description;
    private String picUrl;
    private String url;

    @Override
    public String toString() {
        return "News [title=" + title + ", description=" + description + ", picUrl=" + picUrl + ", url=" + url + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
