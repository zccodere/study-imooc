package com.myimooc.small.advanced.domain;

/**
 * 图片消息
 *
 * @author ZhangCheng on 2017-08-12
 */
public class ImageMessage extends BaseMessage {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
