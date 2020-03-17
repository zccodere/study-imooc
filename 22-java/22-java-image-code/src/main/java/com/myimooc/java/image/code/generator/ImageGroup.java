package com.myimooc.java.image.code.generator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 原始图片分组
 *
 * @author zc 2017-07-09
 */
public class ImageGroup {

    /**
     * 图片组名称
     */
    private String name;
    /**
     * 图片数量
     */
    private int count;
    /**
     * 图片URL组
     */
    private Set<String> images;

    public ImageGroup() {
    }

    public ImageGroup(String name, int count, Set<String> images) {
        this.name = name;
        this.count = count;
        this.images = images;
    }

    public ImageGroup(String name, int count, String... imageNames) {
        this.name = name;
        this.count = count;
        this.images = new HashSet<>(16);
        this.images.addAll(Arrays.asList(imageNames));
    }

    @Override
    public String toString() {
        return "ImageGroup{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", images=" + images +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}
