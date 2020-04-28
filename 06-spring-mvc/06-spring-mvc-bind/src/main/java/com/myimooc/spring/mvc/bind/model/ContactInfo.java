package com.myimooc.spring.mvc.bind.model;

/**
 * 联系方式实体类
 *
 * @author zc 2017-02-19
 */
public class ContactInfo {

    /**
     * 手机
     */
    private String phone;
    /**
     * 地址
     */
    private String address;

    @Override
    public String toString() {
        return "ContactInfo{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
