package com.chenglian.enums;

import com.chenglian.vo.DictionariesResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/9/5.
 */
public enum  DictionariesEnum {
    COMPUTER_BRAND(1,"电脑品牌"),
    PHONE_BRAND(2,"手机品牌");

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

    private static final List<DictionariesResult> resultList = new ArrayList<>();
    static {
        for(DictionariesEnum enums:DictionariesEnum.values()){
            resultList.add(new DictionariesResult(enums.getCode(),enums.getDescribe()));
        }
    }

    public static String getCodeDescribe(Integer code){
        String codeDescribe = null;
        for(DictionariesResult dictionariesResult :resultList){
            if(dictionariesResult.getCode() == code){
                codeDescribe = dictionariesResult.getDescribe();
            }
        }
        return codeDescribe;
    }
}
