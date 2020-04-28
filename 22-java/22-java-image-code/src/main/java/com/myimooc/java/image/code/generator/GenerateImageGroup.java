package com.myimooc.java.image.code.generator;

import java.util.List;

/**
 * 单次验证使用图片组
 *
 * @author zc 2017-07-09
 */
public class GenerateImageGroup {

    /**
     * 需要选中的图片组
     */
    private ImageGroup keyGroup;
    /**
     * 生成大图的小图图片组
     */
    private List<ImageGroup> groups;

    public GenerateImageGroup(ImageGroup keyGroup, List<ImageGroup> groups) {
        this.keyGroup = keyGroup;
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "GenerateImageGroup{" +
                "keyGroup=" + keyGroup +
                ", groups=" + groups +
                '}';
    }

    public ImageGroup getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(ImageGroup keyGroup) {
        this.keyGroup = keyGroup;
    }

    public List<ImageGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ImageGroup> groups) {
        this.groups = groups;
    }
}
