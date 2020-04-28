package com.myimooc.spring.auth.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ID工具类
 *
 * @author zc 2017-08-19
 */
public class IdUtils {

    public static Long getDateTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        int a = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
        String result = sdf.format(new Date()) + a;
        return Long.valueOf(result);
    }
}
