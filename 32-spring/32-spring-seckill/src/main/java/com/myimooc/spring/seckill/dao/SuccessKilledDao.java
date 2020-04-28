package com.myimooc.spring.seckill.dao;

import com.myimooc.spring.seckill.entity.SuccessSeckilled;

import org.apache.ibatis.annotations.Param;

/**
 * 成功秒杀明细dao
 *
 * @author zc 2017-08-22
 */
public interface SuccessKilledDao {

    /**
     * 新增购买明细，可过滤重复
     *
     * @param seckillId 秒杀ID
     * @param userPhone 用户手机号
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     *
     * @param seckillId 秒杀IM
     * @param userPhone 手机号码
     * @return 状态
     */
    SuccessSeckilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
