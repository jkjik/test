package com.chenglian.controller;

import com.chenglian.entity.Account;
import com.chenglian.entity.Commodity;
import com.chenglian.entity.CommodityDetails;
import com.chenglian.entity.CommodityDictionaries;
import com.chenglian.enums.DictionariesEnum;
import com.chenglian.enums.TypeEnum;
import com.chenglian.service.CommodityDetailsService;
import com.chenglian.service.CommodityService;
import com.chenglian.service.DictionariesService;
import com.chenglian.util.BytesToFile;
import com.chenglian.util.FileToBlob;
import com.chenglian.entity.CommodityDetailedMapper;
import com.chenglian.vo.CommodityView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
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
    @Autowired
    private DictionariesService dictionariesServiceImpl;
    @Autowired
    private CommodityDetailsService commodityDetailsServiceImpl;
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
    public String add(Integer sender, String cName, String cType,String signDescribes, Double price,@RequestParam(value = "sendImg", required = false)MultipartFile file){
        Integer type = null;
        try {
            type = Integer.valueOf(cType);
        } catch (NumberFormatException e) {

        }
        Commodity commodity = new Commodity(-1,cName, TypeEnum.getTypeCodeDescribe(type),null,price,sender,onSale,false,new Timestamp(System.currentTimeMillis()));
        commodity.setImage(FileToBlob.changeFileToBlob(file));
        CommodityDictionaries commodityDictionaries = dictionariesServiceImpl.selectByDescribe(signDescribes);
        Integer cId = commodityServiceImpl.add(commodity);
        CommodityDetails commodityDetails = new CommodityDetails(-1,cId, DictionariesEnum.getCodeDescribe(commodityDictionaries.getNumberCode()),signDescribes,false);
        return "commodityPage";
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
        List<CommodityView> commodityViews = new ArrayList<>();
        for(Commodity commodity:commodities){
            CommodityView commodityView = new CommodityView();
            BeanUtils.copyProperties(commodity,commodityView);
            MultipartFile file = BytesToFile.bytesToFile(commodity.getImage());
            commodityView.setImage(file);
            System.out.println(commodityView);
            commodityViews.add(commodityView);
        }

        map.addAttribute("commodityViews",commodityViews);
        return "commodityPage";
    }

    /**
     * 回显图片
     * @param request
     * @param response
     */
    @RequestMapping("showPicture")
    public void showPicture(HttpServletRequest request, HttpServletResponse response){
        String cId = request.getParameter("cId");
        Integer id = null;
        if(null != cId){
            id = Integer.valueOf(cId);
            Commodity commodity = commodityServiceImpl.selectByCId(id);
            byte[] bytes = commodity.getImage();
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 修改提交
     * @param cId
     * @param cName
     * @param price
     * @param file
     * @return
     */
    @RequestMapping(value = "submitAlert" ,produces={"application/json;charset=utf-8"})
    public String submitAlert(String cId,String cName, Double price,@RequestParam(value = "sendImg", required = false)MultipartFile file){
        Integer id = null;
        if(null != cId) {
            id = Integer.valueOf(cId);
        }
        CommodityView commodityView = new CommodityView(id,cName,file,price);
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityView,commodity);
        commodity.setImage(FileToBlob.changeFileToBlob(file));

        commodityServiceImpl.updateAlert(commodity);
        return "commodityPage";
    }

    @RequestMapping("detailed")
    public String detailed(HttpServletRequest request,ModelMap map){
        String id = request.getParameter("cId");
        Integer cId = null;
        try {
             cId= Integer.valueOf(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(null != cId){
            CommodityDetailedMapper commodityDetailedMapper =    commodityServiceImpl.selectDetailedByCId(cId);
            System.out.println(commodityDetailedMapper);
            map.addAttribute("commodityDetailedMapper",commodityDetailedMapper);
        }
        return "commodityDetailedPage";
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
