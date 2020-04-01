package com.gfo.gfo.dto;

import java.util.List;

public class PageResult<T> {
    private Integer page;
    private Integer pageSize;
    private Long total;
    private List<T> list;

    public PageResult(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageResult(PageCondition pageCondition, List<T> list) {
        this.total = pageCondition.getTotal();
        this.page = pageCondition.getPage();
        this.pageSize = pageCondition.getPageSize();
        this.list = list;
    }

    public PageResult(Long total, List<T> list, PageCondition condition) {
        this.total = total;
        this.list = list;
        if (condition != null) {
            this.page = condition.getPage();
            this.pageSize = condition.getPageSize();
        }

    }

    public PageResult(Integer page, Integer pageSize, Long total, List<T> list) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
