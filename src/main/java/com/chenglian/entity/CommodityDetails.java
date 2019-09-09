package com.chenglian.entity;

/**
 * Created by lenovo on 2019/9/9.
 */
public class CommodityDetails {
    private Integer dId;
    private Integer cId;
    private String sign;
    private String signDescribes;
    private Boolean isdelete;

    public CommodityDetails() {
    }

    public CommodityDetails(Integer dId, Integer cId, String sign, String signDescribes, Boolean isdelete) {
        this.dId = dId;
        this.cId = cId;
        this.sign = sign;
        this.signDescribes = signDescribes;
        this.isdelete = isdelete;
    }

    public Integer getdId() {
        return dId;
    }

    public Integer getcId() {
        return cId;
    }

    public String getSign() {
        return sign;
    }

    public String getSignDescribes() {
        return signDescribes;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setSignDescribes(String signDescribes) {
        this.signDescribes = signDescribes;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
