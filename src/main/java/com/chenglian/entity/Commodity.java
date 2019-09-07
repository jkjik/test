package com.chenglian.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by lenovo on 2019/9/7.
 */
public class Commodity {
    private Integer cId;
    private String cName;
    private String cType;
    private byte[] image;
    private Double price;
    private Integer sender;
    private Integer state;
    private Boolean isdelete;
    private Date createTime;

    public Commodity() {
   }

    public Commodity(Integer cId, String cName, String cType, Double price, Integer sender, Integer state, Boolean isdelete, Date createTime) {
        this.cId = cId;
        this.cName = cName;
        this.cType = cType;
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

    public Integer getSender() {
        return sender;
    }

    public Integer getState() {
        return state;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public Boolean getIsdelete() {
        return isdelete;
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

    public void setSender(Integer sender) {
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
