package com.regino.travel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regino.travel.domain.Cart;
import com.regino.travel.domain.User;
import redis.clients.jedis.Jedis;

import java.io.IOException;

public class CartUtils {

    private static ObjectMapper objectMapper=new ObjectMapper();

    // 将购物车设置到redis中
    public static void setCartToRedis(User user, Cart cart){
        try {
            // 获取Jedis连接对象
            Jedis jedis = JedisUtils.getJedis();
            // 将cart转为json
            String json = objectMapper.writeValueAsString(cart);
            // 设置到redis中
            jedis.set("cart_"+user.getUsername(),json);
            // 归还连接
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从redis中获取购物车对象
    public static Cart getCartFromRedis(User user){
        Cart cart = null;
        // 获取jedis连接对象
        Jedis jedis=JedisUtils.getJedis();
        // 判断用户redis中是否有购物车对象
        if(jedis.exists("cart_"+user.getUsername())){ // 存在
            // 从redis中获取
            String json=jedis.get("cart_"+user.getUsername());
            try {
                // 将json转为cart对象
                cart = objectMapper.readValue(json, Cart.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { // 不存在
            // 手动创建空车
            cart = new Cart();
        }
        // 归还连接
        jedis.close();
        return cart;
    }

}
