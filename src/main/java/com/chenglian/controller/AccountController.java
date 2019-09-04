package com.chenglian.controller;

import com.chenglian.entity.Account;
import com.chenglian.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2019/9/3.
 */
@RequestMapping("account")
@Controller
public class AccountController {
    @Autowired
    private AccountService accountServiceImpl;
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
        Account accountEntity = new Account(-1,account,password,grate,new Date());
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
    public String login(String account,String password){
        Account accountEntity = null;
        try {
            accountEntity = accountServiceImpl.selectByAccountAndPassword(account,password);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if(null != accountEntity){
            return "homePage";
        }
        return "forward:/login.jsp";
    }
}
