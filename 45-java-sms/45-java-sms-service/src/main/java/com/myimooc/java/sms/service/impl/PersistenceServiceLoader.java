package com.myimooc.java.sms.service.impl;


import com.myimooc.java.sms.persistence.PersistenceService;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * 使用ClassLoader加载服务
 *
 * @author zc
 * @date 2018/05/29
 */
public class PersistenceServiceLoader {

    public static PersistenceService persistenceService;

    static {
        final Optional<PersistenceService> persistenceService1 = ServiceLoader.load(PersistenceService.class).findFirst();
        persistenceService1.ifPresentOrElse(service -> {
            persistenceService = service;
        }, () -> {
            throw new RuntimeException("未找到 PersistenceService 的实现类");
        });
    }
}
