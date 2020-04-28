package com.myimooc.rabbitmq.ha.dao.mapper;

import com.myimooc.rabbitmq.entity.Order;

import org.springframework.stereotype.Repository;

/**
 * 表 t_order Mapper
 *
 * @author zc
 * @date 2018/09/06
 */
@Repository
public interface OrderMapper {

    /**
     * 新增
     *
     * @param order 订单
     */
    void insert(Order order);

}
