package com.example.demo.service.impl;

import com.example.demo.dao.MessageDAO;
import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import com.example.demo.util.PageData;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private Message message;

    @Resource
    private MessageDAO messageDAO;

    @Override
    public Message sendMessageToAdmin(LocalDateTime outTime, int productId, String messageContent) {
        message.setProductId(productId);
        message.setOutTime(outTime);
        message.setText(messageContent);
        message.setType("false");

        messageDAO.saveMessage(message);
       return message;
    }



    @Override
    @Scheduled(fixedDelay = 60000)
    public void checkUnreadMessages() {
        List<Message> unreadMessages = messageDAO.messageList();
        for (Message message : unreadMessages) {
            if (message.getType().equals("false")){
            LocalDateTime outTime = message.getOutTime();
            long hours = Duration.between(outTime, LocalDateTime.now()).toHours();
            if (hours>3){
                sendSmsToAdmin(message);
            }}

        }
    }



    @Override
    public PageData<Message> getMessagePage(int count, int pageSize, LocalDateTime beforeTime, LocalDateTime afterTime) {

        List<Message> messageList = messageDAO.getMessagePage(count,pageSize,beforeTime,afterTime);
        int total = messageDAO.total(beforeTime, afterTime);


        return new PageData<>(count,pageSize,total,messageList);
    }

    @Override
    public void updateMessageType(int messageId) {

        messageDAO.updateById(messageId);
    }


    private void sendSmsToAdmin(Message message) {
        String content = "您有一条未读消息：" + message.text;

        // 发送短信给 admin 用户
        System.out.println(content);
    }
}
