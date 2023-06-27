package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Ledger {
    // 自增主键
    private int id;
    // 商品id
    private int productId;
    // 门店id
    private int storeId;
    // 数量
    private int num;



    private Date newday;

    public Date getNewday() {
        return newday;
    }

    public void setNewday(Date newday) {
        this.newday = newday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
