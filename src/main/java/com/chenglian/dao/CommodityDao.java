package com.chenglian.dao;

import com.chenglian.entity.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/9/7.
 */
@Repository
public interface CommodityDao {
    void add(Commodity commodity);
    List<Commodity> selectBySender(String sender);
}
