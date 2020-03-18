package com.myimooc.spring.seckill.enums;

/**
 * 使用枚举表述常量数据字典
 *
 * @author zc 2017-08-23
 */
public enum SeckillStatEnum {

    /**
     * 秒杀成功
     */
    SUCCESS(1, "秒杀成功"),
    /**
     * 秒杀结束
     */
    END(0, "秒杀结束"),
    /**
     * 重复秒杀
     */
    REPEAT_KILL(-1, "重复秒杀"),
    /**
     * 系统异常
     */
    INNER_ERROR(-2, "系统异常"),
    /**
     * 数据篡改
     */
    DATA_REWRITE(-3, "数据篡改");

    private int state;

    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateOf(int state) {
        for (SeckillStatEnum statEnum : values()) {
            if (statEnum.getState() == state) {
                return statEnum;
            }
        }
        throw new RuntimeException("状态非法：" + state);
    }
}
