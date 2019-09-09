package com.chenglian.dao;

import com.chenglian.entity.Commodity;
import com.chenglian.entity.CommodityDetailedMapper;
import com.chenglian.entity.CommodityMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/9/7.
 */
@Repository
public interface CommodityDao {
    Integer add(Commodity commodity);
    List<Commodity> selectBySender(String sender);
    Commodity selectByCId(Integer cId);
    void updateAlert(Commodity commodity);
    List<CommodityMapper> selectPage(@Param("start") Integer start, @Param("size") Integer size);
    List<Commodity> selectAll();
    CommodityDetailedMapper selectDetailedByCId(Integer cId);
}
