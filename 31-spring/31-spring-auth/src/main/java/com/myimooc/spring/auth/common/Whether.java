package com.myimooc.spring.auth.common;

/**
 * 是否枚举类
 *
 * @author zc 2017-08-19
 */
public enum Whether {

    /**
     * 否
     */
    NO(0),
    /**
     * 是
     */
    YES(1);

    private int value;

    Whether(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
