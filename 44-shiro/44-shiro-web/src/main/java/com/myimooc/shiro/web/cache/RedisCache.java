package com.myimooc.shiro.web.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.Set;

/**
 * 自定义redis缓存实体类；实现Cache接口
 *
 * @author zc 2018-05-03
 */
@Component
public class RedisCache<K, V> implements Cache<K, V> {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String CACHE_PREFIX = "shiro-cache:";

    private byte[] getKey(K k) {
        if (k instanceof String) {
            return (CACHE_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    @Override
    public V get(K k) throws CacheException {
        System.out.println("从redis中获取权限数据");
        Object value = redisTemplate.opsForValue().get(getKey(k));
        if (value != null) {
            return (V) value;
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        redisTemplate.opsForValue().set(k, v, 600);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = (byte[]) redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
