package com.myimooc.springdata.jdbc.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by ZC on 2017/4/24.
 */
public class JDBCUtilsTest {

    @Test
    public void testGetConnection() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        Assert.assertNotNull(connection);
    }

}
