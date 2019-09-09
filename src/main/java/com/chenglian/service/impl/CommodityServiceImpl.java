package com.chenglian.service.impl;

import com.chenglian.dao.CommodityDao;
import com.chenglian.entity.Commodity;
import com.chenglian.service.CommodityService;
import com.chenglian.entity.CommodityDetailedMapper;
import com.chenglian.entity.CommodityMapper;
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
    public Integer add(Commodity commodity) {
        return commodityDaoImpl.add(commodity);
    }

    @Override
    public List<Commodity> selectBySender(String sender) {
        return commodityDaoImpl.selectBySender(sender);
    }

    @Override
    public Commodity selectByCId(Integer cId) {
        return commodityDaoImpl.selectByCId(cId);
    }

    @Override
    public void updateAlert(Commodity commodity) {
        commodityDaoImpl.updateAlert(commodity);
    }

    @Override
    public List<CommodityMapper> selectPage(Integer start, Integer size) {
        return commodityDaoImpl.selectPage(start,size);
    }

    @Override
    public List<Commodity> selectAll() {
        return commodityDaoImpl.selectAll();
    }

    @Override
    public CommodityDetailedMapper selectDetailedByCId(Integer cId) {
        return commodityDaoImpl.selectDetailedByCId(cId);
    }
}
