package com.regino.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {

    // 测试Jedis内置的连接池
    @Test
    public void test01() throws Exception {

        // 连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100); // 最大连接数
        jedisPoolConfig.setMaxWaitMillis(3000);// 最大等待时间，单位是毫秒，超过会自动抛出异常
        jedisPoolConfig.setMaxIdle(10); // 最大空闲连接数，释放没用的资源

        // 创建连接池对象
        JedisPool jedisPool = new JedisPool("localhost", 6379); // 建议使用IP，用localhost只能连接本地

        // 从池中获取连接
        Jedis jedis = jedisPool.getResource();

        // 操作API
        jedis.hset("myhash", "id", "1");

        // 归还到连接池
        jedis.close();
    }
}