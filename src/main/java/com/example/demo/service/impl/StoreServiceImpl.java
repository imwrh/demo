package com.example.demo.service.impl;

import com.example.demo.dao.StoreDAO;
import com.example.demo.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreDAO storeDAO;

    @Override
    public int performStockOut(int num) {
        return storeDAO.performStockOut(num);
    }

    @Override
    public int performStockIn(int num) {
        return storeDAO.performStockIn(num);
    }
}
