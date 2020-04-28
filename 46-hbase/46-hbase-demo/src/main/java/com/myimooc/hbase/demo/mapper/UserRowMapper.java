package com.myimooc.hbase.demo.mapper;

import com.myimooc.hbase.demo.dto.User;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * 用户表ORM
 *
 * @author zc
 * @date 2018/06/21
 */
public class UserRowMapper implements RowMapper<User> {

    private static byte[] FAMILY_B = "b".getBytes();
    private static byte[] FAMILY_B_NAME = "name".getBytes();
    private static byte[] FAMILY_B_AGE = "age".getBytes();
    private static byte[] FAMILY_B_SEX = "sex".getBytes();

    private static byte[] FAMILY_O = "o".getBytes();
    private static byte[] FAMILY_O_PHONE = "phone".getBytes();
    private static byte[] FAMILY_ADDRESS = "address".getBytes();

    @Override
    public User mapRow(Result result, int i) {
        User.BaseInfo baseInfo = new User.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_B, FAMILY_B_NAME)),
                Bytes.toInt(result.getValue(FAMILY_B, FAMILY_B_AGE)),
                Bytes.toString(result.getValue(FAMILY_B, FAMILY_B_SEX)));
        User.OtherInfo otherInfo = new User.OtherInfo(
                Bytes.toString(result.getValue(FAMILY_O, FAMILY_O_PHONE)),
                Bytes.toString(result.getValue(FAMILY_O, FAMILY_ADDRESS)));
        return new User(Bytes.toString(result.getRow()), baseInfo, otherInfo);
    }
}
