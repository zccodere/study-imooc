package com.myimooc.hbase.demo.dto;

/**
 * 用户表
 *
 * @author zc
 * @date 2018/06/21
 */
public class User {

    /**
     * 行键
     */
    private String row;
    /**
     * 基础信息
     */
    private BaseInfo baseInfo;
    /**
     * 其他信息
     */
    private OtherInfo otherInfo;

    public User() {
    }

    public User(String row, BaseInfo baseInfo, OtherInfo otherInfo) {
        this.row = row;
        this.baseInfo = baseInfo;
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "row='" + row + '\'' +
                ", baseInfo=" + baseInfo +
                ", otherInfo=" + otherInfo +
                '}';
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * 使用内部类表示 b 列簇 基础信息
     */
    public static class BaseInfo {
        /**
         * 名称
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;
        /**
         * 性别
         */
        private String sex;

        public BaseInfo() {
        }

        public BaseInfo(String name, Integer age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    /**
     * 使用内部类表示 o 列簇 其他信息
     */
    public static class OtherInfo {
        /**
         * 电话
         */
        private String phone;
        /**
         * 地址
         */
        private String address;

        public OtherInfo() {
        }

        public OtherInfo(String phone, String address) {
            this.phone = phone;
            this.address = address;
        }

        @Override
        public String toString() {
            return "OtherInfo{" +
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

}
