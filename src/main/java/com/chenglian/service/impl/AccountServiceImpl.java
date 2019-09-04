package com.chenglian.service.impl;

import com.chenglian.dao.AccountDao;
import com.chenglian.entity.Account;
import com.chenglian.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lenovo on 2019/9/4.
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDaoImpl;

    @Override
    public void add(Account account) {
        accountDaoImpl.add(account);
    }

    @Override
    public Account selectByAccount(String account) {
        return accountDaoImpl.selectByAccount(account);
    }

    @Override
    public Account selectByAccountAndPassword(String account, String password) {
        return accountDaoImpl.selectByAccountAndPassword(account,password);
    }
}
