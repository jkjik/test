package com.chenglian.service;

import com.chenglian.entity.Commodity;

import java.util.List;

/**
 * Created by lenovo on 2019/9/7.
 */
public interface CommodityService {
    void add(Commodity commodity);
    List<Commodity> selectBySender(String sender);
}
