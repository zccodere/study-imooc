package com.myimooc.spring.mvc.bind.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ChengComputer on 2017/2/19.
 *
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-19
 */
public class MyDateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return null;
    }
}


