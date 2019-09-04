package com.chenglian.service;

import com.chenglian.entity.Account;

/**
 * Created by lenovo on 2019/9/4.
 */
public interface AccountService {
    void add(Account account);
    Account selectByAccount(String account);
    Account selectByAccountAndPassword(String account,String password);
}
