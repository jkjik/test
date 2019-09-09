package com.chenglian.vo;

/**
 * Created by lenovo on 2019/9/9.
 */
public class DictionaryView {
    private String dType;
    private Integer numberCode;
    private String codeDescribes;
    private String describes;

    public DictionaryView() {
    }

    public DictionaryView(String dType, Integer numberCode, String codeDescribes, String describes) {
        this.dType = dType;
        this.numberCode = numberCode;
        this.codeDescribes = codeDescribes;
        this.describes = describes;
    }

    public String getdType() {
        return dType;
    }

    public Integer getNumberCode() {
        return numberCode;
    }

    public String getCodeDescribes() {
        return codeDescribes;
    }

    public String getDescribes() {
        return describes;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public void setNumberCode(Integer numberCode) {
        this.numberCode = numberCode;
    }

    public void setCodeDescribes(String codeDescribes) {
        this.codeDescribes = codeDescribes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
