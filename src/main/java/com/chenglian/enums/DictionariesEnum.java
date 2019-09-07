package com.chenglian.enums;

/**
 * Created by lenovo on 2019/9/5.
 */
public enum  DictionariesEnum {
    COMPUTER_BRAND(001,"电脑品牌"),
    PHONE_BRAND(002,"手机品牌");

    DictionariesEnum(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    private Integer code;
    private String describe;

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
