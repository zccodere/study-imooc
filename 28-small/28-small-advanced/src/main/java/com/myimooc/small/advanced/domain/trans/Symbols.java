package com.myimooc.small.advanced.domain.trans;

import java.util.Arrays;

/**
 * 百度翻译API
 *
 * @author zc 2017-08-12
 */
public class Symbols {

    private String phAm;
    private String phEn;
    private String phZh;
    private Parts[] parts;

    @Override
    public String toString() {
        return "Symbols{" +
                "phAm='" + phAm + '\'' +
                ", phEn='" + phEn + '\'' +
                ", phZh='" + phZh + '\'' +
                ", parts=" + Arrays.toString(parts) +
                '}';
    }

    public String getPhAm() {
        return phAm;
    }

    public void setPhAm(String phAm) {
        this.phAm = phAm;
    }

    public String getPhEn() {
        return phEn;
    }

    public void setPhEn(String phEn) {
        this.phEn = phEn;
    }

    public String getPhZh() {
        return phZh;
    }

    public void setPhZh(String phZh) {
        this.phZh = phZh;
    }

    public Parts[] getParts() {
        return parts;
    }

    public void setParts(Parts[] parts) {
        this.parts = parts;
    }
}
