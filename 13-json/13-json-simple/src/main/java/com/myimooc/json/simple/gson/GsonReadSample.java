package com.myimooc.json.simple.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.myimooc.json.simple.model.Person;
import com.myimooc.json.simple.model.PersonWithBirthday;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 使用Gson解析 JSON 文件
 *
 * @author zc 2017-05-21
 */
public class GsonReadSample {

    public static void main(String[] args) throws IOException {
        createJsonByGsonFile();
    }

    /**
     * 读取 JSON 数据
     */
    private static void createJsonByGsonFile() throws IOException {
        File file = new File(GsonReadSample.class.getResource("/wang_er.json").getFile());

        String content = FileUtils.readFileToString(file, "UTF-8");

        // 无日期转换
        Gson gson = new Gson();

        Person wang = gson.fromJson(content, Person.class);
        System.out.println(wang.toString());

        // 带日期转换
        Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        PersonWithBirthday wangEr = gson2.fromJson(content, PersonWithBirthday.class);

        System.out.println(wangEr.getBirthday().toString());

        // 集合类解析
        System.out.println(wangEr.getMajor());
        System.out.println(wangEr.getMajor().getClass());
    }
}
