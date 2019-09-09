package com.chenglian.dao;

import com.chenglian.entity.CommodityDetails;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2019/9/9.
 */
@Repository
public interface CommodityDetailsDao {
    void add(CommodityDetails commodityDetails);
}
