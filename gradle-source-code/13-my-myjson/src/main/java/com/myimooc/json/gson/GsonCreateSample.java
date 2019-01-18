package com.myimooc.json.gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myimooc.json.model.Diaosi;

import java.lang.reflect.Field;

/**
 * 使用 GSON 进行 JSON 相关操作
 * Created by ChangComputer on 2017/5/21.
 */
public class GsonCreateSample {

    public static void main(String[] args) {
        createJsonByGsonBean();
    }

    /**
     *
     * 通过 JavaBean 生成JSON【推荐使用】
     */
    private static void createJsonByGsonBean() {
        Diaosi wangxiaoer = new Diaosi();

        wangxiaoer.setName("王小二");
        wangxiaoer.setAge(25.2);
        wangxiaoer.setBirthday("1990-01-01");
        wangxiaoer.setSchool("蓝翔");
        wangxiaoer.setMajor(new String[]{"理发","挖掘机"});
        wangxiaoer.setHas_girlfriend(false);
        wangxiaoer.setCar(null);
        wangxiaoer.setHouse(null);
        wangxiaoer.setComment("这是一个注释");
        wangxiaoer.setIgnore("不要看见我");

        GsonBuilder gsonBuilder = new GsonBuilder();
        // 设置格式化输出
        gsonBuilder.setPrettyPrinting();
        // 自定义转换策略
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                if(f.getName().equals("name")){
                    return "NAME";
                }
                return f.getName();
            }
        });
        // 生成Gson
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(wangxiaoer));
    }
}
