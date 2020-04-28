package com.myimooc.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis的测试
 *
 * @author zc 2017-05-21
 */
public class JedisDemoTest {

    public static void main(String[] args) {
        demo1();
        demo2();
    }

    /**
     * 单实例的测试
     */
    private static void demo1() {
        // 1.设置IP地址和端口
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2.保存数据
        jedis.set("name", "myimooc");
        // 3.获取数据
        String value = jedis.get("name");

        System.out.println(value);

        // 4.释放资源
        jedis.close();
    }

    /**
     * 使用连接池方式连接
     */
    private static void demo2() {
        // 获得连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(30);
        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        // 获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        // 通过连接池获得连接
        Jedis jedis = jedisPool.getResource();
        // 设置数据
        jedis.set("name", "张三");
        // 获取数据
        String value = jedis.get("name");
        System.out.println(value);
        // 释放资源
        jedis.close();
        // 释放连接池
        jedisPool.close();
    }
}
