package com.myimooc.json.simple.gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myimooc.json.simple.model.Diaosi;

import java.lang.reflect.Field;

/**
 * <br>
 * 标题: 使用 GSON 进行 JSON 相关操作<br>
 * 描述: 使用 GSON 进行 JSON 相关操作<br>
 * 时间: 2017/05/21<br>
 *
 * @author zc
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
        wangxiaoer.setHasGirlfriend(false);
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
                String name = "name";
                if(name.equals(f.getName())){
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
