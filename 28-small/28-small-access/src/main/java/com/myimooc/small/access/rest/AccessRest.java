package com.myimooc.small.access.rest;

import com.myimooc.small.access.domain.AccessRequestVo;
import com.myimooc.small.access.util.CheckUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开发模式接入
 *
 * @author zc 2017-08-11
 */
@RestController
public class AccessRest {

    /**
     * 接收微信服务器发送的GET验证请求
     */
    @GetMapping("wx")
    public String access(AccessRequestVo vo) {
        if (CheckUtils.checkSignature(vo)) {
            return vo.getEchostr();
        }
        return "error";
    }
}
