package com.chenglian.vo;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

/**
 * Created by lenovo on 2019/9/8.
 */
public class CommodityView {
    private Integer cId;
    private String cName;
    private MultipartFile image;
    private Double price;

    public CommodityView() {
    }

    public CommodityView(Integer cId, String cName, MultipartFile image, Double price) {
        this.cId = cId;
        this.cName = cName;
        this.image = image;
        this.price = price;
    }

    public Integer getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public MultipartFile getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
