package com.myimooc.springbootweb.service;

import com.myimooc.springbootweb.model.entity.Girl;

/**
 * Created by ChengComputer on 2017/2/18.
 */
public interface GirlService {

    /**
     * 插入两个女生信息
     */
    void saveTwo();

    void getAge(Integer id)throws Exception;

    Girl findOne(Integer id);
}
