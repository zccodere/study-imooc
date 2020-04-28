package com.myimooc.hbase.demo.service;

import com.alibaba.fastjson.JSON;
import com.myimooc.hbase.demo.HbaseDemoApplication;
import com.myimooc.hbase.demo.dto.User;

import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 *
 * @author zc
 * @date 2018/06/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = HbaseDemoApplication.class)
public class UserHbaseServiceImplTest {

    @Autowired
    private HbaseService<User> service;

    /**
     * 数据表名称
     */
    private String tableName;

    @Before
    public void init() {
        tableName = "demo:user";
    }

    @Test
    public void testFindByRow() {
        System.out.println(JSON.toJSONString(service.findByRow(tableName, "root")));
    }

    @Test
    public void testFindByStartEndRow() {
        System.out.println(JSON.toJSONString(service.findByStartEndRow(tableName, "r", "z")));
    }

    @Test
    public void testSaveOrUpdate() {
        List<Mutation> mutationList = new ArrayList<>();
        Put put = new Put(Bytes.toBytes("root"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("name"), Bytes.toBytes("imooc"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("age"), Bytes.toBytes("18"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("sex"), Bytes.toBytes("m"));
        put.addColumn(Bytes.toBytes("o"), Bytes.toBytes("phone"), Bytes.toBytes("123456789"));
        put.addColumn(Bytes.toBytes("o"), Bytes.toBytes("address"), Bytes.toBytes("北京市朝阳区"));
        mutationList.add(put);

//        Delete delete = new Delete(Bytes.toBytes("root"));
//        mutationList.add(delete);

        List<Mutation> results = service.saveOrUpdate(tableName, mutationList);
        System.out.println(results);
    }
}
