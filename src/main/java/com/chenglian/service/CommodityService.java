package com.chenglian.service;

import com.chenglian.entity.Commodity;
import com.chenglian.entity.CommodityDetailedMapper;
import com.chenglian.entity.CommodityMapper;

import java.util.List;

/**
 * Created by lenovo on 2019/9/7.
 */
public interface CommodityService {
    Integer add(Commodity commodity);
    List<Commodity> selectBySender(String sender);
    Commodity selectByCId(Integer cId);
    void updateAlert(Commodity commodity);
    List<CommodityMapper> selectPage(Integer start, Integer size);
    List<Commodity> selectAll();
    CommodityDetailedMapper selectDetailedByCId(Integer cId);
}

