package com.example.demo.dao;

import com.example.demo.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MessageDAO {
//    void sendMessageToAdmin(String identity, Date outTime, String messageContent);
//    void checkUnreadMessages();

    void  saveMessage(Message message);

    List<Message> messageList();

    List<Message> getMessagePage(@Param("count") int count,@Param("pageSize") int pageSize,
                                 @Param("beforeTime") LocalDateTime beforeTime,@Param("afterTime") LocalDateTime afterTime);

    int total (@Param("beforeTime") LocalDateTime beforeTime,@Param("afterTime") LocalDateTime afterTime);
     void   updateById(int messageId);
}
