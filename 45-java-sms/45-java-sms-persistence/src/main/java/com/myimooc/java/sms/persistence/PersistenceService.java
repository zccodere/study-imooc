package com.myimooc.java.sms.persistence;


import com.myimooc.java.sms.model.BaseEntity;

import java.util.List;

/**
 * 持久化服务
 *
 * @author zc
 * @date 2018/05/29
 */
public interface PersistenceService {

    /**
     * 获取多个对象
     *
     * @param type 实体类型
     * @param <T>  实体类型
     * @return 实体实例集合
     * @throws PersistenceException 持久化异常
     */
    <T extends BaseEntity> List<T> list(Class<T> type) throws PersistenceException;

    /**
     * 获取单个对象
     *
     * @param type 实体类型
     * @param id   ID
     * @param <T>  实体类型
     * @return 实体实例
     * @throws PersistenceException 持久化异常
     */
    <T extends BaseEntity> T getOne(Class<T> type, String id) throws PersistenceException;

    /**
     * 保存一个实体（兼容创建和更新）
     *
     * @param entity 实体
     * @throws PersistenceException 持久化异常
     */
    void save(BaseEntity entity) throws PersistenceException;

    /**
     * 删除一个实体
     *
     * @param type 实体类型
     * @param id   ID
     * @param <T>  实体类型
     * @throws PersistenceException 持久化异常
     */
    <T extends BaseEntity> void remove(Class<T> type, String id) throws PersistenceException;
}
