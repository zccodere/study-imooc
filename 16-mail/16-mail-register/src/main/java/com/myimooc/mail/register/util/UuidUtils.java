package com.myimooc.mail.register.util;

import java.util.UUID;

/**
 * <br>
 * 标题: 生成随机字符串工具类<br>
 * 描述: 生成随机字符串工具类<br>
 * 时间: 2017/06/07<br>
 *
 * @author zc
 */
public class UuidUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
