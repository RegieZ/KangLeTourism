package com.regino.travel.dao;

import com.regino.travel.domain.Order;
import com.regino.travel.domain.OrderItem;
import org.apache.ibatis.annotations.Update;

public interface OrderItemDao {
    void save(OrderItem orderItem);

    @Update("update tab_orderitem set state = 1 where oid = #{oid}") // 既用xml也用注解，节约时间
    void updateState(String oid);
}
