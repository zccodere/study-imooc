package com.myimooc.small.advanced.domain.trans;

/**
 * 百度翻译API
 *
 * @author ZhangCheng on 2017-08-12
 */
public class Symbols {
    private String phAm;
    private String phEn;
    private String phZh;
    private Parts[] parts;

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
