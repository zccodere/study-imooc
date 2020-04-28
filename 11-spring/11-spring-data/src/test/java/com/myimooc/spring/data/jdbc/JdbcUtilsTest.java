package com.myimooc.spring.data.jdbc;

import com.myimooc.spring.data.jdbc.util.JdbcUtils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * JDBC测试类
 *
 * @author zc 2017-04-24
 */
public class JdbcUtilsTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        Assert.assertNotNull(connection);
    }

}
