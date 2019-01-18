package com.imooc.util;

import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {


    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}
