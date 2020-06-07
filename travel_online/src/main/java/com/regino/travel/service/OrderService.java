package com.regino.travel.service;

import com.regino.travel.domain.Order;
import com.regino.travel.domain.ResultInfo;

import java.util.Map;

public interface OrderService {
    void save(Order order);

    void updateState(Map<String, String> param);

    ResultInfo findState(String oid);
}
