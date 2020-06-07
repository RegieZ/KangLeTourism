package com.regino.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {

    // 向Redis设置String类型的数据
    @Test
    public void test01() throws Exception {
        // 1.创建连接对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2.调用set方法设置数据，cmd会将中文转为Unicode
        jedis.set("Regino", "你好");
        // 3.释放资源，底层是Socket
        jedis.close();
    }

    // 查询String类型数据
    @Test
    public void test02() throws Exception {
        // 1.创建连接对象
        Jedis jedis = new Jedis(); // 默认连接 127.0.0.1 主机 和 6379 端口
        // 2.调用get方法获取
        String java = jedis.get("Regino");
        System.out.println(java);
        // 3.释放资源
        jedis.close();
    }
}