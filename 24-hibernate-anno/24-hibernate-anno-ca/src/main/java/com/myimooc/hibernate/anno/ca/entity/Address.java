package com.myimooc.hibernate.anno.ca.entity;

import javax.persistence.Embeddable;

/**
 * 地址类（嵌入类）；@Embeddable 表示是一个嵌入类，这个类的对象在另一个实体类中充当属性
 *
 * @author zc 2017-07-12
 */
@Embeddable
public class Address {

    /**
     * 邮编
     */
    private String postCode;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String phone;

    @Override
    public String toString() {
        return "Address [postCode=" + postCode + ", address=" + address + ", phone=" + phone + "]";
    }

    public Address() {
    }

    public Address(String postCode, String address, String phone) {
        this.postCode = postCode;
        this.address = address;
        this.phone = phone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
