package com.chenglian.vo;

/**
 * Created by lenovo on 2019/9/9.
 */
public class DictionariesResult {
    private Integer code;
    private String describe;

    public DictionariesResult() {
    }

    public DictionariesResult(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
