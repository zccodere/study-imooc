package com.myimooc.json.simple.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.myimooc.json.simple.model.Person;

/**
 * 使用 GSON 进行 JSON 相关操作
 *
 * @author zc 2017-05-21
 */
public class GsonCreateSample {

    public static void main(String[] args) {
        createJsonByGsonBean();
    }

    /**
     * 通过 JavaBean 生成JSON【推荐使用】
     */
    private static void createJsonByGsonBean() {
        Person wangEr = new Person();
        wangEr.setName("王小二");
        wangEr.setAge(25.2);
        wangEr.setBirthday("1990-01-01");
        wangEr.setHasGirlfriend(false);
        wangEr.setCar(null);
        wangEr.setHouse(null);
        wangEr.setComment("这是一个注释");
        wangEr.setIgnore("不要看见我");
        wangEr.setSchool("蓝翔");
        wangEr.setMajor(new String[]{"理发", "挖掘机"});

        GsonBuilder gsonBuilder = new GsonBuilder();
        // 设置格式化输出
        gsonBuilder.setPrettyPrinting();
        // 自定义转换策略；使用 JDK8 的 Lambda 表达式
        gsonBuilder.setFieldNamingStrategy(f -> {
            String name = "name";
            if (name.equals(f.getName())) {
                return "NAME";
            }
            return f.getName();
        });
        // 生成Gson
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(wangEr));
    }
}
