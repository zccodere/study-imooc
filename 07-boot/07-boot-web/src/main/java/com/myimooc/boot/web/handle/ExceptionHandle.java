package com.myimooc.boot.web.handle;

import com.myimooc.boot.web.exception.ResponseException;
import com.myimooc.boot.web.model.entity.Result;
import com.myimooc.boot.web.utils.ResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author zc 2017-03-19
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 全局异常返回处理
     *
     * @param ex 异常
     * @return 处理后的返回结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception ex) {
        if (ex instanceof ResponseException) {
            ResponseException responseException = (ResponseException) ex;
            return ResultUtil.error(responseException.getRespCode(), responseException.getMessage());
        }
        logger.error("系统异常：", ex);
        return ResultUtil.error(ResultUtil.RESPONSE_CODE_ERROR_SERVICE, "未知错误");
    }
}
