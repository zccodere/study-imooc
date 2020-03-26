package com.myimooc.boot.start.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 逆向生成mapper、po；根据数据库表结构生成代码
 *
 * @author zc 2018-04-26
 */
public class GeneratorDisplay {

    public void generator() throws Exception {
        List<String> warnings = new ArrayList<>();
        //指定 逆向工程配置文件
        String pathname = GeneratorDisplay.class.getClassLoader().getResource("generatorConfig.xml").getPath();
        File configFile = new File(pathname);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) {
        try {
            GeneratorDisplay generatorSqlmap = new GeneratorDisplay();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
