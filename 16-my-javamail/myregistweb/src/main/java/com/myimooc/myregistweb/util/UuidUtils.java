package com.myimooc.myregistweb.util;

import java.util.UUID;

/**
 * 生成随机字符串工具类
 * @create ZhangCheng by 2017-06-08
 *
 */
public class UuidUtils {
    
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    
}
