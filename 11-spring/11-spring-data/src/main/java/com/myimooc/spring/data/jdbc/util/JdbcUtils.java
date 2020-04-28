package com.myimooc.spring.data.jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类；获取Connection、释放资源
 *
 * @author zc 2017-04-24
 */
public class JdbcUtils {

    /**
     * 获取Connection
     *
     * @return 所获得到的JDBC的Connection
     */
    public static Connection getConnection() throws Exception {
        // 不建议大家把配置硬编码到代码中；最佳实践：配置性的建议写到配置文件中
        // String url = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        // String username = "root";
        // String password = "root5770";
        // String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 释放DB相关资源
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
