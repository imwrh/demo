package com.example.demo.controller;

import com.example.demo.entity.Ledger;
import com.example.demo.service.LedgerService;
import com.example.demo.util.PageData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/ledger")
public class LedgerController {

    @Resource
    private LedgerService ledgerService;

    @Resource
    private Ledger ledger;

    @GetMapping("/performStockOut")
    public ResponseEntity<Integer>  performStockOut(@PathVariable("productId") int productId,@PathVariable("num") int num,@PathVariable("storeId") int storeId){



        return ResponseEntity.ok(ledgerService.performStockOut(productId,num,storeId));
    }

    @GetMapping("/performStockIn")
    public ResponseEntity<Integer> performStockIn(int productId, int num, int storeId){

        return ResponseEntity.ok(ledgerService.performStockIn(productId,num,storeId));
    }

    public ResponseEntity<PageData<Ledger>> getLedgerByCriteria(@PathVariable("productName") String productName,
                                                                @PathVariable("startDate") Date startDate,
                                                                @PathVariable("offset") int offset,
                                                                @PathVariable("pageSize") int pageSize){
        return ResponseEntity.ok(ledgerService.getLedgerByCriteria(productName,startDate,offset,pageSize));
    }

    @GetMapping("/Totalprice")
    public ResponseEntity<Map> Totalprice(@PathVariable("productId") int productId){
        return ResponseEntity.ok(ledgerService.Totalprice(productId));
    }
}
