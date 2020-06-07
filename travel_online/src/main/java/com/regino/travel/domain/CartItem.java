package com.regino.travel.domain;

import lombok.Data;

// 购物项对象
@Data
public class CartItem {

    private Route route; // 商品
    private Integer num; // 数量
    private Double subTotal; // 小计

    // 重写小计方法
    public Double getSubTotal() {
        subTotal = route.getPrice() * num;
        return subTotal;
    }
}
