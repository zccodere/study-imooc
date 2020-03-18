package com.myimooc.small.advanced.domain;

/**
 * 图片
 *
 * @author zc 2017-08-12
 */
public class Image {

    private String mediaId;

    @Override
    public String toString() {
        return "Image{" +
                "mediaId='" + mediaId + '\'' +
                '}';
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
