package com.myimooc.boot.web.handle;

import com.myimooc.boot.web.utils.ResultUtil;
import com.myimooc.boot.web.exception.RespException;
import com.myimooc.boot.web.model.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获类
 * @author ZhangCheng
 * @date 2017-03-19
 * @version V1.0
 *
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 全局异常返回处理
     * @param e 异常
     * @return 处理后的返回结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof RespException){
            RespException respException = (RespException)e;
            return ResultUtil.error(respException.getRespCode(),respException.getMessage());
        }
        LOGGER.error("【系统异常】{}",e);
        return ResultUtil.error(ResultUtil.RESPCODE_ERROR_SERVICE,"未知错误");
    }

}

