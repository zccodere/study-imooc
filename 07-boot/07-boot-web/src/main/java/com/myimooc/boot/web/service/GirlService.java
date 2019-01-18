package com.myimooc.boot.web.service;

import com.myimooc.boot.web.model.entity.Girl;

/**
 * <br>
 * 标题: 业务服务<br>
 * 描述: 业务服务<br>
 * 时间: 2017/02/18<br>
 *
 * @author zc
 */
public interface GirlService {

    /**
     * 新增两个女生信息
     */
    void saveTwo();

    /**
     * 获取年龄
     *
     * @param id
     * @throws Exception
     */
    void getAge(Integer id) throws Exception;

    /**
     * 获取女生信息
     *
     * @param id
     * @return
     */
    Girl findOne(Integer id);
}
