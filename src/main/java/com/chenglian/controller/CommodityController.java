package com.chenglian.controller;

import com.chenglian.entity.Account;
import com.chenglian.entity.Commodity;
import com.chenglian.service.CommodityService;
import com.chenglian.util.FileToBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2019/9/6.
 */
@RequestMapping("commodity")
@Controller
public class CommodityController {
    @Autowired
    private CommodityService commodityServiceImpl;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("YYYY-MM-DD HH:MM:SS"),
                true));
    }
    private static final Integer onSale = 0;
    private static final Integer outSale =1;

    /**
     * 上传商品
     * @param sender
     * @param cName
     * @param cType
     * @param price
     * @param file
     * @return
     */
    @RequestMapping(value = "add" ,produces={"application/json;charset=utf-8"})
    public String add(Integer sender, String cName, String cType, Double price,@RequestParam(value = "sendImg", required = false)MultipartFile file){
        Commodity commodity = new Commodity(-1,cName,cType,price,sender,onSale,false,new Date());
        FileToBlob.changeFileToBlob(file,commodity);
        System.out.println(commodity);
        commodityServiceImpl.add(commodity);
        return "homePage";
    }

    /**
     * 修改商品回显
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("alert")
    public String alert(ModelMap map, HttpSession session){
        Account account =(Account)session.getAttribute("account");
        List<Commodity> commodities = commodityServiceImpl.selectBySender(account.getId()+"");
        map.addAttribute("commodities",commodities);
        return "homePage";
    }

/*    @RequestMapping("sendPicture")
    @ResponseBody
    public String sendPicture( @RequestParam(value = "sendImg", required = false)MultipartFile file){
        if(file == null){
            System.out.println(false);
            return   "no";
        }else {
            System.out.println(true);
            return  "yes";
        }
    }*/
}
