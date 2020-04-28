package com.myimooc.freemarker.simple.controller;

import freemarker.core.Environment;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Freemarker自定义指令；实现Freemarker顶层TemplateDirectiveModel指令接口，且实现execute方法
 *
 * @author zc 2017-03-20
 */
public class RoleDirectiveModel implements TemplateDirectiveModel {

    /**
     * env：环境变量 params：指令参数（存储你所需要的值，随便是什么，Key-Value格式） loopVars：循环变量 body：指令内容
     * 除了params外，其他的都是是null
     */
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        System.out.println("==========>自定义指令ROLE<==========");
        // 获取参数
        TemplateScalarModel user = (TemplateScalarModel) params.get("user");
        TemplateScalarModel role = (TemplateScalarModel) params.get("role");

        // 判断用户编号及角色是否匹配
        String userId = "123456";
        String userRole = "admin";
        if (userId.equals(user.getAsString()) && userRole.equals(role.getAsString())) {
            loopVars[0] = TemplateBooleanModel.TRUE;
        }

        // 封装返回对象
        List<String> otherRights = new ArrayList<>();
        otherRights.add("add");
        otherRights.add("delete");
        otherRights.add("update");
        // 该类SimpleSequence是过时的，请自己查官方文档
        loopVars[1] = new SimpleSequence(otherRights, null);

        body.render(env.getOut());
    }
}
