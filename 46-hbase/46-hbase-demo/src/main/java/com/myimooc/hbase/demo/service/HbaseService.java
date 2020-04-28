package com.myimooc.hbase.demo.service;

import org.apache.hadoop.hbase.client.Mutation;

import java.util.List;

/**
 * HBase服务
 *
 * @author zc
 * @date 2018/06/21
 */
public interface HbaseService<T> {

    /**
     * 查询指定行键的表数据
     *
     * @param tableName 表名
     * @param row       行键
     * @return 数据
     */
    T findByRow(String tableName, String row);

    /**
     * 查询指定行键之间的表数据
     *
     * @param tableName 表名
     * @param startRow  开始行键
     * @param endRow    结束行键
     * @return 数据集合
     */
    List<T> findByStartEndRow(String tableName, String startRow, String endRow);

    /**
     * 保存或修改数据
     *
     * @param tableName    表名
     * @param mutationList 数据集合
     * @return 数据集合
     */
    List<Mutation> saveOrUpdate(String tableName, List<Mutation> mutationList);

}
