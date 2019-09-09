package com.chenglian.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by lenovo on 2019/9/9.
 */
@Repository
public class CommodityMapper {
    private Integer cId;
    private String cName;
    private String cType;
    private byte[] image;
    private Double price;
    private String sender;
    private Integer state;
    private Boolean isdelete;
    private Date createTime;

    public CommodityMapper() {
    }

    public CommodityMapper(Integer cId, String cName, String cType, byte[] image, Double price, String sender, Integer state, Boolean isdelete, Date createTime) {
        this.cId = cId;
        this.cName = cName;
        this.cType = cType;
        this.image = image;
        this.price = price;
        this.sender = sender;
        this.state = state;
        this.isdelete = isdelete;
        this.createTime = createTime;
    }

    public Integer getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public String getcType() {
        return cType;
    }

    public byte[] getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public String getSender() {
        return sender;
    }

    public Integer getState() {
        return state;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
