package com.chenglian.service.impl;

import com.chenglian.dao.CommodityDetailsDao;
import com.chenglian.entity.CommodityDetails;
import com.chenglian.service.CommodityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2019/9/9.
 */
@Service
public class CommodityDetailsServiceImpl implements CommodityDetailsService{
    @Autowired
    private CommodityDetailsDao commodityDetailsDaoImpl;
    @Override
    public void add(CommodityDetails commodityDetails) {
        commodityDetailsDaoImpl.add(commodityDetails);
    }
}
