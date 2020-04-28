package com.myimooc.spring.seckill.dao;

import com.myimooc.spring.seckill.entity.Seckill;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品库存dao
 *
 * @author zc 2017-08-22
 */
public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId 秒杀ID
     * @param killTime  秒杀时间
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") Long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     *
     * @param seckillId 秒杀ID
     * @return 秒杀对象
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset 偏移量
     * @param limit  条数
     * @return 商品列表
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap 参数
     */
    void killByProcedure(Map<String, Object> paramMap);
}
