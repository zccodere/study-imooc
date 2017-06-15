package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by 廖师兄
 * 2017-01-21 14:05
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
