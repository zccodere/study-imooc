package com.myimooc.java.image.code.generator;

import java.awt.image.BufferedImage;

/**
 * 图片包装类
 *
 * @author zc 2017-07-09
 */
public class BufferedImageWrap {

    /**
     * 是否为答案项
     */
    private boolean key;
    /**
     * 图片缓冲类
     */
    private BufferedImage bufferedImage;

    public BufferedImageWrap() {
    }

    public BufferedImageWrap(boolean key, BufferedImage bufferedImage) {
        this.key = key;
        this.bufferedImage = bufferedImage;
    }

    @Override
    public String toString() {
        return "BufferedImageWrap{" +
                "key=" + key +
                ", bufferedImage=" + bufferedImage +
                '}';
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
