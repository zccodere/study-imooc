package com.myimooc.json.simple.demo;

import com.myimooc.json.simple.model.Diaosi;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 * 标题: 生成 JSON 数据格式演示类<br>
 * 描述: 生成 JSON 数据格式演示类<br>
 * 时间: 2017/05/21<br>
 *
 * @author zc
 */
public class JsonObjectSample {

    public static void main(String[] args) {
//        createJsonByJsonObject();
//        createJsonByMap();
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
        JSONObject wangxiaoer = new JSONObject();
        // 定义nullObject
        Object nullObject = null;
        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 25.2);
        wangxiaoer.put("birthday", "1990-01-01");
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_girlfriend", false);
        // 使用nullObject跳过编译器检查
        wangxiaoer.put("car", nullObject);
        wangxiaoer.put("house", nullObject);
        wangxiaoer.put("comment", "这是一个注释");

        System.out.println(wangxiaoer.toString());

    }

    /**
     * 通过 HashMap 生成JSON
     */
    public static void createJsonByMap() {
        Map<String, Object> wangxiaoer = new HashMap<String, Object>(16);

        Object nullObject = null;
        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 25.2);
        wangxiaoer.put("birthday", "1990-01-01");
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_girlfriend", false);
        // 使用nullObject跳过编译器检查
        wangxiaoer.put("car", nullObject);
        wangxiaoer.put("house", nullObject);
        wangxiaoer.put("comment", "这是一个注释");
        // 通过 JSONObject 的构造函数接收一个 Map 生成 JSON
        System.out.println(new JSONObject(wangxiaoer).toString());
    }

    /**
     * 通过 JavaBean 生成JSON【推荐使用】
     */
    public static void createJsonByBean() {
        Diaosi wangxiaoer = new Diaosi();

        wangxiaoer.setName("王小二");
        wangxiaoer.setAge(25.2);
        wangxiaoer.setBirthday("1990-01-01");
        wangxiaoer.setSchool("蓝翔");
        wangxiaoer.setMajor(new String[]{"理发", "挖掘机"});
        wangxiaoer.setHasGirlfriend(false);
        wangxiaoer.setCar(null);
        wangxiaoer.setHouse(null);
        wangxiaoer.setComment("这是一个注释");

        // 通过 JSONObject 的构造函数接收一个 Bean 生成 JSON
        System.out.println(new JSONObject(wangxiaoer).toString());
    }

}
