package com.myimooc.spring.seckill.service;

import com.myimooc.spring.seckill.dto.Exposer;
import com.myimooc.spring.seckill.dto.SeckillExecution;
import com.myimooc.spring.seckill.entity.Seckill;
import com.myimooc.spring.seckill.exception.RepeatKillException;
import com.myimooc.spring.seckill.exception.SeckillCloseException;
import com.myimooc.spring.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度设计接口 三个方面：方法定义粒度、参数、返回类型（return 类型/异常）
 *
 * @author zc 2017-08-23
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return 秒杀列表
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId 秒杀ID
     * @return 秒杀记录
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     *
     * @param seckillId 秒杀ID
     * @return 接口地址
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId 秒杀ID
     * @param userPhone 手机号码
     * @param md5       MD5
     * @return 执行
     * @throws SeckillException      秒杀异常
     * @throws RepeatKillException   重复秒杀异常
     * @throws SeckillCloseException 秒杀关闭异常
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀操作，存储过程
     *
     * @param seckillId 秒杀ID
     * @param userPhone 手机号码
     * @param md5       MD5
     * @return 执行
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
