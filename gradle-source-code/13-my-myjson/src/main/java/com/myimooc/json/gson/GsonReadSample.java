package com.myimooc.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myimooc.json.demo.ReadJsonSample;
import com.myimooc.json.model.Diaosi;
import com.myimooc.json.model.DiaosiWithBirthday;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 使用Gson解析 JSON 文件
 * Created by ChangComputer on 2017/5/21.
 */
public class GsonReadSample {
    public static void main(String[] args) throws IOException {
        createJsonByGsonFile();
    }

    /**
     * 读取 JSON 数据
     * */
    public static void createJsonByGsonFile() throws IOException {
        File file = new File(GsonReadSample.class.getResource("/wangxiaoer.json").getFile());

        String content = FileUtils.readFileToString(file,"UTF-8");

        // 无日期转换
        Gson gson = new Gson();

        Diaosi wangxiaoer = gson.fromJson(content,Diaosi.class);

        System.out.println(wangxiaoer.toString());

        // 带日期转换
        Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        DiaosiWithBirthday wangxiaoer2 = gson2.fromJson(content,DiaosiWithBirthday.class);

        System.out.println(wangxiaoer2.getBirthday().toString());

        // 集合类解析
        System.out.println(wangxiaoer2.getMajor());
        System.out.println(wangxiaoer2.getMajor().getClass());

    }
}
