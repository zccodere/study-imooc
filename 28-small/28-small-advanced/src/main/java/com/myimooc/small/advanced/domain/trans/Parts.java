package com.myimooc.small.advanced.domain.trans;

import java.util.Arrays;

/**
 * 百度翻译API
 *
 * @author zc 2017-08-12
 */
public class Parts {

    private String part;
    private String[] means;

    @Override
    public String toString() {
        return "Parts{" +
                "part='" + part + '\'' +
                ", means=" + Arrays.toString(means) +
                '}';
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String[] getMeans() {
        return means;
    }

    public void setMeans(String[] means) {
        this.means = means;
    }
}
