package com.regino.travel.service;

import com.regino.travel.domain.PageBean;
import com.regino.travel.domain.Route;

public interface RouteService {

    // 无搜索条件分页查询
    PageBean<Route> findByPage(int currentPage, int pageSize, String cid);

    // 有搜索条件的分页查询
    PageBean<Route> findByPage(int currentPage, int pageSize, String cid, String rname);

    // 线路详情展示
    Route findDetail(String rid);
}
