package com.chenglian.controller;

import com.chenglian.entity.CommodityDictionaries;
import com.chenglian.enums.DictionariesEnum;
import com.chenglian.enums.TypeEnum;
import com.chenglian.service.DictionariesService;
import com.chenglian.vo.DictionaryView;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.enterprise.inject.spi.Bean;
import java.io.IOException;
import java.util.ArrayList;
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

    /**
     * 字典主页
     * @param map
     * @return
     */
    @RequestMapping("vindicate")
    public String vindicate(ModelMap map){
        List<CommodityDictionaries> dictionariesList = dictionariesServiceImpl.selectAll();
        List<DictionaryView> dictionaryViewList = new ArrayList<>();
        for (CommodityDictionaries dictionaries : dictionariesList){
            DictionaryView dictionaryView = new DictionaryView();
            BeanUtils.copyProperties(dictionaries,dictionaryView);
            dictionaryView.setdType(TypeEnum.getTypeCodeDescribe(dictionaries.getdType()));
            dictionaryView.setCodeDescribes(DictionariesEnum.getCodeDescribe(dictionaries.getNumberCode()));
            dictionaryViewList.add(dictionaryView);
        }
        map.addAttribute("dictionaryViewList",dictionaryViewList);
        return "dictionariesPage";
    }

    /*@RequestMapping("add")
    public String add(){
        return "addDictionariesPage";
    }*/
}
