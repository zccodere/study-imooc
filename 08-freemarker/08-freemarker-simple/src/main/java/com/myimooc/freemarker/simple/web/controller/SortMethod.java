package com.myimooc.freemarker.simple.web.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * Freemarker自定义函数，整数排序
 * //实现TemplateMethodModelEx接口并实现exec方法
 * @author ZhangCheng
 * @date 2017-03-20
 * @version V1.0
 */
public class SortMethod implements TemplateMethodModelEx {

    @SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        //获取第一个参数
        SimpleSequence arg0 = (SimpleSequence)arguments.get(0);
        //SimpleSequence的toList是一个过时的方法，查阅官方文档，却没有替代方法
        List<BigDecimal> list = arg0.toList();
        //使用Collections的排序方法进行排序
        Collections.sort(list,new Comparator<BigDecimal>(){
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                //return o2.intValue()-o1.intValue();//降序
                //升序
                return o1.intValue()-o2.intValue();
            }
        });
        return list;
    }
}
