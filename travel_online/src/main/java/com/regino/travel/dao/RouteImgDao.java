package com.regino.travel.dao;

import com.regino.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    // 根据rid查询线路列表
    List<RouteImg> findByRid(Integer rid);
}
