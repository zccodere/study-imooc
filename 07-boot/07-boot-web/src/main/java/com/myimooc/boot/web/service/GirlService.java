package com.myimooc.boot.web.service;

import com.myimooc.boot.web.exception.ResponseException;
import com.myimooc.boot.web.model.entity.Girl;

/**
 * 服务层
 *
 * @author zc 2017-02-18
 */
public interface GirlService {

    /**
     * 新增两个女生信息
     */
    void saveTwo();

    /**
     * 获取年龄
     *
     * @param id 主键ID
     * @throws ResponseException 业务异常
     */
    void getAge(Integer id) throws ResponseException;

    /**
     * 获取女生信息
     *
     * @param id 主键ID
     * @return 女生信息
     */
    Girl findOne(Integer id);
}
