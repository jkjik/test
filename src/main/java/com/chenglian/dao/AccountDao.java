package com.chenglian.dao;

import com.chenglian.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2019/9/3.
 */
@Repository
public interface AccountDao {
    //添加
    void add(Account account);
    //ajax判断账户是否存在
    Account selectByAccount(String account);
    //登录
    Account selectByAccountAndPassword(@Param("account") String account,@Param("password") String password);
    //列表
    List<Account> selectAll();
}
