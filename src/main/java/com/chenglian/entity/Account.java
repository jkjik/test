package com.chenglian.entity;

import java.util.Date;

/**
 * Created by lenovo on 2019/9/3.
 */
public class Account {
    private Integer id;
    private String account;
    private String password;
    private int grade;
    private Date createTime;

    public Account() {
    }

    public Account(Integer id, String account, String password, int grade, Date createTime) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.grade = grade;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }


    public int getGrade() {
        return grade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                ", createTime=" + createTime +
                '}';
    }
}
