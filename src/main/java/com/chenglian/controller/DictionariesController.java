package com.chenglian.controller;

import com.chenglian.entity.CommodityDictionaries;
import com.chenglian.service.DictionariesService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2019/9/5.
 */
@RequestMapping("dictionary")
@Controller
public class DictionariesController {
    @Autowired
    private DictionariesService dictionariesServiceImpl;

    /**
     * 数据库获得类型下拉选项
     * @param dType
     * @return
     */
    @RequestMapping(value = "getOption",method= RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String getOption(Integer dType){
        List<CommodityDictionaries> dictionaries = dictionariesServiceImpl.selectByDType(dType);
        ObjectMapper mapper = new ObjectMapper();
        String json= null;
        try {
            json = mapper.writeValueAsString(dictionaries);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
