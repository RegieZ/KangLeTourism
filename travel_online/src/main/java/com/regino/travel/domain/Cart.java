package com.regino.travel.domain;

import lombok.Data;

import java.util.LinkedHashMap;

// 购物车对象
@Data
public class Cart {

    private Integer cartNum; // 购物车数量
    private Double cartTotal; // 购物车总金额
    private LinkedHashMap<String, CartItem> cartItemMap = new LinkedHashMap<>(); // 购物车集合，保证不出现空指针异常

    // 重写购物车数量get方法
    public Integer getCartNum() {
        // 清除操作
        cartNum = 0;

        // 遍历购物项集合
        for (CartItem cartItem : cartItemMap.values()) {
            // 累加
            cartNum += cartItem.getNum();
        }
        return cartNum;
    }

    // 重写购物车总金额方法
    public Double getCartTotal() {
        // 清除操作
        cartTotal = 0.0;

        // 遍历购物项集合
        for (CartItem cartItem : cartItemMap.values()) {
            cartTotal += cartItem.getSubTotal();
        }
        return cartTotal;
    }
}
