package com.chenglian.service.impl;

import com.chenglian.dao.CommodityDao;
import com.chenglian.entity.Commodity;
import com.chenglian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/9/7.
 */
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private CommodityDao commodityDaoImpl;

    @Override
    public void add(Commodity commodity) {
        commodityDaoImpl.add(commodity);
    }

    @Override
    public List<Commodity> selectBySender(String sender) {
        return commodityDaoImpl.selectBySender(sender);
    }
}
