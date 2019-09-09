package com.chenglian.entity;

/**
 * Created by lenovo on 2019/9/5.
 */
public class CommodityDictionaries {
    private Integer dId;
    private Integer dType;
    private Integer numberCode;
    private String describes;

    public CommodityDictionaries() {
    }

    public CommodityDictionaries(Integer dId, Integer dType, Integer numberCode, String describes) {
        this.dId = dId;
        this.dType = dType;
        this.numberCode = numberCode;
        this.describes = describes;
    }

    public Integer getdId() {
        return dId;
    }

    public Integer getdType() {
        return dType;
    }

    public Integer getNumberCode() {
        return numberCode;
    }

    public String getDescribes() {
        return describes;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public void setdType(Integer dType) {
        this.dType = dType;
    }

    public void setNumberCode(Integer numberCode) {
        this.numberCode = numberCode;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @Override
    public String toString() {
        return "CommodityDictionaries{" +
                "dId=" + dId +
                ", dType=" + dType +
                ", numberCode=" + numberCode +
                ", describes='" + describes + '\'' +
                '}';
    }
}
