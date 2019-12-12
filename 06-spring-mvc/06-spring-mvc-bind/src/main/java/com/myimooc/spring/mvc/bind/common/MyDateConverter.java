package com.myimooc.spring.mvc.bind.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ChengComputer on 2017/2/19.
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-19
 */
public class MyDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

