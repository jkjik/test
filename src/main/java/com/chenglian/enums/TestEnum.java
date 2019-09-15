package com.chenglian.enums;

/**
 * Created by lenovo on 2019/9/10.
 */
public enum  TestEnum {
    COMPUTER_BRAND(1,"电脑品牌"),
    PHONE_BRAND(2,"手机品牌");

    TestEnum(Integer code, String describe) {
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

    public static String getCodeDescribe(Integer code) {
        String codeDescribe = null;
        TestEnum[] values = TestEnum.values();
        for (int i=0;i<values.length;i++){
            if (values[i].getCode() == code) {
                codeDescribe = values[i].getDescribe();
            }
        }
        return codeDescribe;
    }
}
