package com.chenglian.dao;

import com.chenglian.entity.CommodityDictionaries;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/9/5.
 */
@Repository
public interface DictionariesDao {
    //添加
    void add (CommodityDictionaries commodityDictionaries);
    //通过数据码查看
    List<CommodityDictionaries> selectByNumberCode(Integer numberCode);
    //查看所有
    List<CommodityDictionaries> selectAll();
    //通过描述查询
    CommodityDictionaries selectByDescribe(String describe);
    //通过类型查询
    List<CommodityDictionaries> selectByDType(Integer dType);
}
