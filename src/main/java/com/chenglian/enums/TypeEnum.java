package com.chenglian.enums;

/**
 * Created by lenovo on 2019/9/5.
 */
public enum TypeEnum {
    COMPUTER(1,"电脑"),
    PHONE(2,"手机");

    TypeEnum(Integer key, String dType) {
        this.key = key;
        this.dDype = dType;
    }

    private Integer key;
    private String dDype;
}
