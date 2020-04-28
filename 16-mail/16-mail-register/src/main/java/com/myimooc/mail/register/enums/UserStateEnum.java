package com.myimooc.mail.register.enums;

/**
 * 用户状态枚举类
 *
 * @author zc 2020-03-16
 */
public enum UserStateEnum {

    /**
     * 未激活
     */
    NOT_ACTIVE(0),
    /**
     * 已激活
     */
    ACTIVATED(1);

    /**
     * 枚举值
     */
    private Integer value;

    UserStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
