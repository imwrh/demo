package com.example.demo.util;

import java.util.List;

public class PageData<T> {
    private int current;
    private int pageSize;
    private int total;
    private List<T> data;

    public PageData(int current, int pageSize, int total, List<T> data) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
