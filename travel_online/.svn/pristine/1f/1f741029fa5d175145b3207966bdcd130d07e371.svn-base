package com.regino.travel.dao;

import com.regino.travel.domain.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderDao {
    void save(Order order);

    @Update("update tab_order set state = 1 where oid = #{oid}")
    void updateState(String oid);

    @Select("select * from tab_order where oid =#{oid}")
    Order findByOid(String oid);
}
