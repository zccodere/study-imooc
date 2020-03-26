package com.myimooc.shiro.web.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义缓存管理器；使用Redis进行缓存
 *
 * @author zc 2018-05-03
 */
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisCache redisCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
