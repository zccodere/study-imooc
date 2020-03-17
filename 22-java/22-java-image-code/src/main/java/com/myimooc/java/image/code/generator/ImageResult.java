package com.myimooc.java.image.code.generator;

import java.util.Set;

/**
 * 图片结果类
 *
 * @author zc 2017-07-09
 */
public class ImageResult {

    /**
     * 图片名称
     */
    private String name;
    /**
     * 键集合
     */
    private Set<Integer> keySet;
    /**
     * 唯一标识
     */
    private String uniqueKey;
    /**
     * 需要选中的图片提示
     */
    private String tip;

    @Override
    public String toString() {
        return "ImageResult{" +
                "name='" + name + '\'' +
                ", keySet=" + keySet +
                ", uniqueKey='" + uniqueKey + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getKeySet() {
        return keySet;
    }

    public void setKeySet(Set<Integer> keySet) {
        this.keySet = keySet;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
