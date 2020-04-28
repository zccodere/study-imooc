package com.myimooc.small.advanced.domain;

/**
 * 图片消息
 *
 * @author zc 2017-08-12
 */
public class ImageMessage extends BaseMessage {

    private Image image;

    @Override
    public String toString() {
        return super.toString() + "ImageMessage{" +
                "image=" + image +
                '}';
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
