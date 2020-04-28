package com.myimooc.json.simple.demo;

import com.myimooc.json.simple.model.Person;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成 JSON 数据格式演示类
 *
 * @author zc 2017-05-21
 */
public class JsonObjectSample {

    public static void main(String[] args) {
        createJsonByJsonObject();
        createJsonByMap();
        createJsonByBean();
    }

/* 目标数据格式
{
	"name" : "王小二",
	"age" : 25.2,
	"birthday" : "1990-01-01",
	"school" : "蓝翔",
	"major" : ["理发","挖掘机"],
	"has_girlfriend" : false,
	"car" : null,
	"house" : null,
	"comment" : "这是一个注释"
}
 */

    /**
     * 通过 JSONObject 生成JSON
     */
    private static void createJsonByJsonObject() {
        JSONObject wangEr = new JSONObject();

        wangEr.put("name", "王小二");
        wangEr.put("age", 25.2);
        wangEr.put("birthday", "1990-01-01");
        wangEr.put("school", "蓝翔");
        wangEr.put("major", new String[]{"理发", "挖掘机"});
        wangEr.put("has_girlfriend", false);
        // 使用nullObject跳过编译器检查
        Void nullObject = null;
        wangEr.put("car", nullObject);
        wangEr.put("house", nullObject);
        wangEr.put("comment", "这是一个注释");

        System.out.println(wangEr.toString());
    }

    /**
     * 通过 HashMap 生成JSON
     */
    private static void createJsonByMap() {
        Map<String, Object> params = new HashMap<>(16);
        params.put("name", "王小二");
        params.put("age", 25.2);
        params.put("birthday", "1990-01-01");
        params.put("has_girlfriend", false);

        params.put("school", "蓝翔");
        params.put("major", new String[]{"理发", "挖掘机"});
        params.put("car", null);
        params.put("house", null);
        params.put("comment", "这是一个注释");
        // 通过 JSONObject 的构造函数接收一个 Map 生成 JSON
        System.out.println(new JSONObject(params).toString());
    }

    /**
     * 通过 JavaBean 生成JSON【推荐使用】
     */
    private static void createJsonByBean() {
        Person person = new Person();
        person.setName("王小二");
        person.setAge(25.2);
        person.setBirthday("1990-01-01");
        person.setHasGirlfriend(false);
        person.setSchool("蓝翔");
        person.setMajor(new String[]{"理发", "挖掘机"});
        person.setCar(null);
        person.setHouse(null);
        person.setComment("这是一个注释");
        // 通过 JSONObject 的构造函数接收一个 Bean 生成 JSON
        System.out.println(new JSONObject(person).toString());
    }
}
