package com.regino.travel.dao;

import com.regino.travel.domain.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteDao {

    Integer findCount(@Param("cid") String cid, @Param("rname") String rname);

    List<Route> findList(@Param("index") int index, @Param("pageSize") int pageSize, @Param("cid") String cid, @Param("rname") String rname);

    Route findByRidWithAll(String rid);
}
