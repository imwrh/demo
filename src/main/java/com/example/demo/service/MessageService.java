package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.util.PageData;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MessageService {
    Message sendMessageToAdmin(LocalDateTime outTime, int product, String messageContent);
    void checkUnreadMessages();

    PageData<Message> getMessagePage(int count, int pageSize, LocalDateTime beforeTime, LocalDateTime afterTime);

     void updateMessageType(int messageId);
}
