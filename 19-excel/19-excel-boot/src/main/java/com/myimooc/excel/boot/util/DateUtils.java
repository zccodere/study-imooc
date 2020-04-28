package com.myimooc.excel.boot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author zc 2017-07-08
 */
public class DateUtils {

    public static String dateTimeToString(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }

    public static String nowToString() {
        return dateTimeToString(new Date());
    }

    public static Long getTimeInstant() {
        Date date = new Date();
        return date.getTime();
    }
}
