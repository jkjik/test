package com.chenglian.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2019/9/9.
 */
@Repository
public class CommodityDetailedMapper implements Serializable{
    private Integer cId;
    private String cName;
    private String cType;
    private byte[] image;
    private Double price;
    private String sender;
    private Integer state;
    private Boolean isdelete;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
    private String sign;
    private String signDescribes;

    public CommodityDetailedMapper() {
    }

    public CommodityDetailedMapper(Integer cId, String cName, String cType, byte[] image, Double price, String sender, Integer state, Boolean isdelete, Timestamp createTime, String sign, String signDescribes) {
        this.cId = cId;
        this.cName = cName;
        this.cType = cType;
        this.image = image;
        this.price = price;
        this.sender = sender;
        this.state = state;
        this.isdelete = isdelete;
        this.createTime = createTime;
        this.sign = sign;
        this.signDescribes = signDescribes;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public String getSign() {
        return sign;
    }

    public String getSignDescribes() {
        return signDescribes;
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setSignDescribes(String signDescribes) {
        this.signDescribes = signDescribes;
    }
}
