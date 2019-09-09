package com.chenglian.controller;

import com.chenglian.entity.Account;
import com.chenglian.entity.Commodity;
import com.chenglian.service.AccountService;
import com.chenglian.service.CommodityService;
import com.chenglian.entity.CommodityMapper;
import com.chenglian.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2019/9/3.
 */
@RequestMapping("account")
@Controller
public class AccountController {
    @Autowired
    private AccountService accountServiceImpl;
    @Autowired
    private CommodityService commodityServiceImpl;
    //默认等级权限
    private static final Integer grate = 1;
    private Account accountEntity;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("YYYY-MM-DD HH:MM:SS"),
                true));
    }

    /**
     * 注册
     * @param account
     * @param password
     */
    @RequestMapping("register")
    public String add(String account,String password){
        accountEntity = new Account(-1,account,password,grate, new Timestamp(System.currentTimeMillis()));
        accountServiceImpl.add(accountEntity);
        return "login";
    }

    /**
     * 检验账户
     * @param account
     * @return
     */
    @RequestMapping("checkSameAccount")
    @ResponseBody
    public String checkSameAccount(String account){
        Account accountEntity = accountServiceImpl.selectByAccount(account);
        if(null != accountEntity){
            return "yes";
        }else {
            return "no";
        }
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String account, String password, HttpSession session, ModelMap map){
        Account accountEntity = null;
        try {
            accountEntity = accountServiceImpl.selectByAccountAndPassword(account,password);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if(null != accountEntity){
            Integer size = 2;
            Integer currentPage =1;
            List<Account> accountList = accountServiceImpl.selectAll();
            List<CommodityMapper> commodityList = commodityServiceImpl.selectPage(currentPage-1,size);
            List<Commodity> totalList = commodityServiceImpl.selectAll();
            if(null != commodityList){
                Integer totalNumber = totalList.size();
                Integer page = totalNumber%size ==0?totalNumber/size:(totalNumber/size)+1;
                PageBean<CommodityMapper> pageBean = new PageBean<>(totalNumber,size,page,currentPage,commodityList);
                map.addAttribute("accountList",accountList);
                map.addAttribute("pageBean",pageBean);
                session.setAttribute("account",accountEntity);
            }
            return "page";
        }
        return "forward:/login.jsp";
    }
    @RequestMapping("gotoPage")
    public String gotoPage(ModelMap map){
        Integer size = 2;
        Integer currentPage =1;
        List<Account> accountList = accountServiceImpl.selectAll();
        List<CommodityMapper> commodityList = commodityServiceImpl.selectPage(currentPage-1,size);
        List<Commodity> totalList = commodityServiceImpl.selectAll();
        if(null != commodityList) {
            Integer totalNumber = totalList.size();
            Integer page = totalNumber % size == 0 ? totalNumber / size : (totalNumber / size) + 1;
            PageBean<CommodityMapper> pageBean = new PageBean<>(totalNumber, size, page, currentPage, commodityList);
            map.addAttribute("accountList", accountList);
            map.addAttribute("pageBean", pageBean);
        }
        return "page";
    }
    /**
     * 登录跳转
     * @return
     */
    @RequestMapping("accountLogin")
    public String accountLogin(){
        return "login";
    }

    /**
     * 发布商品跳转
     * @return
     */
    @RequestMapping("sendCommodity")
    public String sendCommodity(){
        return "commodityPage";
    }

    /**
     * 修改商品跳转
     * @return
     */
    @RequestMapping("myCommodity")
    public String myCommodity(){
        return "forward:/commodity/alert";
    }
    /**
     * 分页查询
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("pageQuery")
    public String pageQuery(HttpServletRequest request,ModelMap map){
        String sign = request.getParameter("sign");
        String size = request.getParameter("size");
        String currentPage = request.getParameter("currentPage");

        Integer newSize = Integer.valueOf(size);
        Integer newCurrentPage = Integer.valueOf(currentPage);
        List<CommodityMapper> commodityList = null;
        if("1".equals(sign)){
            commodityList = commodityServiceImpl.selectPage(newCurrentPage-newSize+1,newSize);
            newCurrentPage = newCurrentPage-1;
        }
        if("2".equals(sign)){
            commodityList = commodityServiceImpl.selectPage(newCurrentPage+newSize-1,newSize);
            newCurrentPage = newCurrentPage+1;
        }
        List<Account> accountList = accountServiceImpl.selectAll();
        List<Commodity> totalList = commodityServiceImpl.selectAll();
        Integer totalNumber = totalList.size();
        Integer page = totalNumber%newSize ==0?totalNumber/newSize:(totalNumber/newSize)+1;
        PageBean<CommodityMapper> pageBean = new PageBean<>(totalNumber,newSize,page,newCurrentPage,commodityList);
        map.addAttribute("accountList",accountList);
        map.addAttribute("pageBean",pageBean);
        return "page";
    }
}
