package com.myimooc.mail.register.util;

import java.util.UUID;

/**
 * 生成随机字符串工具类
 *
 * @author zc 2017-06-07
 */
public class UuidUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
