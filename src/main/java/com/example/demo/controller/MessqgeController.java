package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import com.example.demo.util.PageData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/messqge")
public class MessqgeController {

    @Resource
    private MessageService messageService;

    public ResponseEntity<PageData<Message>> getMessagePage(@PathVariable("count") int count, @PathVariable("pageSize") int pageSize,
                                         @PathVariable("beforeTime") LocalDateTime beforeTime, @PathVariable("afterTime") LocalDateTime afterTime){

        return ResponseEntity.ok(messageService.getMessagePage(count,pageSize,beforeTime,afterTime));
    }

}
