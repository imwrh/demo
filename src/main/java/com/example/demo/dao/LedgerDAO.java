package com.example.demo.dao;

import com.example.demo.entity.Ledger;
import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface LedgerDAO {
    void performStockOut(int productId, int num, int storeId);

    void performStockIn(int productId, int num,int storeId);

    int selectByProductIdAndStoreId(int productId,int storeId);

    List<Ledger> getLedgerByCriteria(@Param("productId") int productId,@Param("startDate") Date startDate,
                                     @Param("offset") int offset,@Param("pageSize") int pageSize);

    int getLedgerCountByCriteria(int productId, Date startDate);

    int selectSumByProductI(int productId);

}
