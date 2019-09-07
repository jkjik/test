package com.chenglian.service.impl;

import com.chenglian.dao.DictionariesDao;
import com.chenglian.entity.CommodityDictionaries;
import com.chenglian.service.DictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/9/5.
 */
@Service
public class DictionariesServiceImpl implements DictionariesService {
    @Autowired
    private DictionariesDao dictionariesDaoImpl;

    @Override
    public void add(CommodityDictionaries commodityDictionaries) {
        dictionariesDaoImpl.add(commodityDictionaries);
    }

    @Override
    public List<CommodityDictionaries> selectByNumberCode(Integer numberCode) {
        return dictionariesDaoImpl.selectByNumberCode(numberCode);
    }

    @Override
    public List<CommodityDictionaries> selectAll() {
        return dictionariesDaoImpl.selectAll();
    }

    @Override
    public CommodityDictionaries selectByDescribe(String describe) {
        return dictionariesDaoImpl.selectByDescribe(describe);
    }

    @Override
    public List<CommodityDictionaries> selectByDType(Integer dType) {
        return dictionariesDaoImpl.selectByDType(dType);
    }
}
