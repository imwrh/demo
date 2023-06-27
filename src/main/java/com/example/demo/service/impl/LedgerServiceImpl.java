package com.example.demo.service.impl;


import com.example.demo.dao.LedgerDAO;
import com.example.demo.entity.Ledger;
import com.example.demo.entity.Product;
import com.example.demo.service.LedgerService;
import com.example.demo.service.MessageService;
import com.example.demo.service.ProductService;
import com.example.demo.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LedgerServiceImpl implements LedgerService {
    @Resource
    private LedgerDAO ledgerDAO;

    @Resource
    private MessageService messageService;

    @Resource
    private ProductService productService;

    @Override
    public int performStockOut(int productId, int num, int storeId) {

        Product product = productService.getProductById(productId);

        String message="用户购买的"+product.getName()+"，已于"+LocalDateTime.now()+"发货，购买的数量为"+num;

        messageService.sendMessageToAdmin(LocalDateTime.now(),productId,message);


        // 调用DAO层方法进行出库操作，返回指定门店的商品现存数量
        ledgerDAO.performStockOut(productId, num, storeId);


        return ledgerDAO.selectByProductIdAndStoreId(productId,storeId);
    }

    @Override
    public int performStockIn(int productId, int num, int storeId) {
        // 调用DAO层方法进行入库操作，返回指定门店的商品现存数量
        ledgerDAO.performStockIn(productId, num, storeId);
        return ledgerDAO.selectByProductIdAndStoreId(productId,storeId);
    }

    @Override
    public PageData<Ledger> getLedgerByCriteria(String productName, Date startDate, int offset, int pageSize) {
        int productId = productService.selectByName(productName);
        offset=(offset-1)*pageSize;
        List<Ledger> ledgerByCriteria = ledgerDAO.getLedgerByCriteria(productId, startDate, offset, pageSize);

        int total = ledgerDAO.getLedgerCountByCriteria(productId, startDate);
        int totalPages = (int) Math.ceil((double) total / pageSize);
        return new PageData<>(offset, pageSize,  totalPages, ledgerByCriteria);
    }


    @Override
    public Map<Object,Object> Totalprice(int productId) {
        Product product = productService.getProductById(productId);

        int productSum = ledgerDAO.selectSumByProductI(productId);

        float totalprice;
        totalprice=product.getPrice()*productSum;

        HashMap<Object, Object> map = new HashMap<>();
        map.put(productSum,totalprice);
        return map;
    }


}
