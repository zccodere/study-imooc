package com.myimooc.hbase.demo.service.impl;

import com.myimooc.hbase.demo.dto.User;
import com.myimooc.hbase.demo.mapper.UserRowMapper;
import com.myimooc.hbase.demo.service.HbaseService;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 *
 * @author zc
 * @date 2018/06/22
 */
@Service
public class UserHbaseServiceImpl implements HbaseService<User> {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Override
    public User findByRow(String tableName, String row) {
        return hbaseTemplate.get(tableName, row, new UserRowMapper());
    }

    @Override
    public List<User> findByStartEndRow(String tableName, String startRow, String endRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(endRow));
        return hbaseTemplate.find(tableName, scan, new UserRowMapper());
    }

    @Override
    public List<Mutation> saveOrUpdate(String tableName, List<Mutation> datas) {
        hbaseTemplate.saveOrUpdates(tableName, datas);
        return datas;
    }
}
