package com.chenglian.enums;

import com.chenglian.vo.DictionariesResult;

import java.util.ArrayList;
import java.util.List;

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

    public Integer getKey() {
        return key;
    }

    public String getdDype() {
        return dDype;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setdDype(String dDype) {
        this.dDype = dDype;
    }

    private static final List<DictionariesResult> resultList = new ArrayList<>();
    static {
        for(TypeEnum enums:TypeEnum.values()){
            resultList.add(new DictionariesResult(enums.getKey(),enums.getdDype()));
        }
    }

    public static String getTypeCodeDescribe(Integer code){
        String codeDescribe = null;
        for(DictionariesResult dictionariesResult :resultList){
            if(dictionariesResult.getCode() == code){
                codeDescribe = dictionariesResult.getDescribe();
            }
        }
        return codeDescribe;
    }
}
