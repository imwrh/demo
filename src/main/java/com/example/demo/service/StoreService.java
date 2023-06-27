package com.example.demo.service;

public interface StoreService {
    //出库后总量
    int performStockOut(int num);
    //入库后总量
    int performStockIn(int num);
}
