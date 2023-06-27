package com.example.demo.service;

import com.example.demo.entity.Ledger;
import com.example.demo.util.PageData;

import java.util.Date;
import java.util.Map;

public interface LedgerService {
    int performStockOut(int productId, int num, int storeId);

    int performStockIn(int productId, int num, int storeId);

    PageData<Ledger> getLedgerByCriteria(String name, Date startDate, int offset, int pageSize);

    Map<Object,Object> Totalprice(int productId);
}
