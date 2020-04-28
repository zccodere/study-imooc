package com.myimooc.freemarker.simple.controller;

import freemarker.template.SimpleNumber;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Freemarker自定义函数，整数排序
 *
 * @author zc 2017-03-20
 */
public class SortMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        // 获取第一个参数
        SimpleSequence simpleSequence = (SimpleSequence) arguments.get(0);
        // SimpleSequence 的 toList是一个过时的方法，查阅官方文档，却没有替代方法；这里使用自己的 toList 方法
        List<BigDecimal> list = this.toList(simpleSequence);
        // 使用 JDK8 提供的 Lambda 表达式进行排序，默认升序
        list.sort(Comparator.comparing(BigDecimal::intValue));
        return list;
    }

    private List<BigDecimal> toList(SimpleSequence simpleSequence) throws TemplateModelException {
        if (Objects.isNull(simpleSequence)) {
            return Collections.emptyList();
        }

        int size = simpleSequence.size();
        List<BigDecimal> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            TemplateModel templateModel = simpleSequence.get(i);
            if (templateModel instanceof SimpleNumber) {
                SimpleNumber number = (SimpleNumber) templateModel;
                list.add(new BigDecimal(number.toString()));
            }
        }
        return list;
    }
}
