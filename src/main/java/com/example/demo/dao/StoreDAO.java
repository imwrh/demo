package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreDAO {
    //出库后总量
    int performStockOut(int num);
    //入库后总量
    int performStockIn(int num);

}
