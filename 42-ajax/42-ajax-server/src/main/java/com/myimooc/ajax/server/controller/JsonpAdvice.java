package com.myimooc.ajax.server.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * <br>
 * 标题: JSONP 全局处理<br>
 * 描述: 统一处理JSONP<br>
 *
 * @author zc
 * @date 2018/04/18
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{

    public JsonpAdvice() {
        // 与前端约定好回调方法名称，默认是callback
        super("callback2");
    }
}
