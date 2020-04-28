package com.myimooc.java.watermark.domain;

/**
 * 图片信息模型类
 *
 * @author zc 2017-07-21
 */
public class PicInfo {

    /**
     * 原图访问路径
     */
    private String imageUrl;
    /**
     * 添加水印后的访问路径
     */
    private String logoImageUrl;

    @Override
    public String toString() {
        return "PicInfo [imageUrl=" + imageUrl + ", logoImageUrl=" + logoImageUrl + "]";
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }
}
