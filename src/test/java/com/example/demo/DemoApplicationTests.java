package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.dao.LedgerDAO;
import com.example.demo.dao.MessageDAO;
import com.example.demo.entity.Ledger;
import com.example.demo.entity.Message;
import com.example.demo.entity.Product;
import com.example.demo.service.LedgerService;
import com.example.demo.service.MessageService;
import com.example.demo.service.ProductService;
import lombok.extern.flogger.Flogger;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {
//    private static final Logger logger = LogManager.getLogger(DemoApplicationTests.class);
    @Resource
    private ProductService productService;

    @Resource
    private LedgerService ledgerService;

    @Resource
    private LedgerDAO ledgerDAO;

    @Resource
    private MessageDAO messageDAO;

    @Resource
    private MessageService messageService;




    @Resource
    private Product product;

    @Test
    void contextLoads() {

        product.setName("xiaomi10");
        productService.addProduct(product);
    }

    @Test
    void text1(){
        int i = ledgerService.performStockIn(1, 10, 1);
        System.out.println(i);
    }

    @Test
    void text2() throws ParseException {
//        String dateString = "2020-05-05";
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat.parse(dateString);
//        List<Ledger> ledgerList = ledgerService.getLedgerByCriteria("mate50", date, 0, 1);
//        System.out.println(productService.selectByName("mate50"));
//        for (Ledger ledger : ledgerList) {
//            System.out.println(ledger.getId() + " " + ledger.getProductId() + " " + ledger.getNewday());
//        }
    }

    @Test
    void text3(){
        int i = ledgerDAO.selectSumByProductI(1);
        System.out.println(i);
    }

    @Test
    void text4(){
        int i = ledgerService.performStockOut(1, 10, 1);
        System.out.println(i);
    }

    @Test
    void text5(){
        LocalDateTime startTime = LocalDateTime.of(2022, 6, 30, 13, 30, 42);
        LocalDateTime endTime = LocalDateTime.of(2023, 6, 30, 13, 30, 42);
//        List<Message> messageList = messageService.getMessagePage(0,1,startTime);
        List<Message> messageList = messageDAO.getMessagePage(0, 1, startTime, endTime);
        System.out.println(messageList==null);
//        logger.info(messageList);
        for (Message message : messageList) {
            System.out.println(message.getText());
            System.out.println(message.getOutTime());
            System.out.println(message.getId());

        }

    }

    @Test
    void text6(){
        messageService.updateMessageType(2);
    }

}
