package com.chenglian.vo;

import java.util.List;

/**
 * Created by lenovo on 2019/9/8.
 */
public class PageBean<T> {
    //总条数
    private Integer totalNumber;
    //每页显示条数
    private Integer size;
    //总页数
    private Integer page;
    //当前页
    private Integer currentPage;
    private List<T> beanList;

    public PageBean() {
    }

    public PageBean(Integer totalNumber, Integer size, Integer page, Integer currentPage, List<T> beanList) {
        this.totalNumber = totalNumber;
        this.size = size;
        this.page = page;
        this.currentPage = currentPage;
        this.beanList = beanList;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
