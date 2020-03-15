package com.myimooc.boot.web.utils;

import com.myimooc.boot.web.model.entity.Result;

/**
 * http请求返回的实体Bean工具类
 *
 * @author zc 2017-03-19
 */
public class ResultUtil {

    /**
     * 成功
     */
    public final static Integer RESPONSE_CODE_SUCCESS = 200;
    /**
     * 请求参数错误
     */
    public final static Integer RESPONSE_CODE_ERROR_PARAM = 300;
    /**
     * 系统内部业务错误
     */
    public final static Integer RESPONSE_CODE_ERROR_SERVICE = 400;
    /**
     * 系统内部异常
     */
    public final static Integer RESPONSE_CODE_ERROR_EXECEPTION = 500;

    /**
     * 执行成功，返回参数
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setRespCode(ResultUtil.RESPONSE_CODE_SUCCESS);
        result.setRespMsg("成功");
        result.setData(data);
        return result;
    }

    /**
     * 执行成功，无返回参数
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 执行错误
     */
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setRespCode(code);
        result.setRespMsg(msg);
        return result;
    }
}
