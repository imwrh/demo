package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import com.example.demo.util.PageData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/messqge")
public class MessqgeController {

    @Resource
    private MessageService messageService;

   @GetMapping("/getMessagePage")
   public ResponseEntity<PageData<Message>> getMessagePage(@RequestParam("count") int count,
                                           @RequestParam("pageSize") int pageSize,@RequestParam("beforeTime")  LocalDateTime beforeTime,
                                           @RequestParam("afterTime")  LocalDateTime afterTime){
       return ResponseEntity.ok( messageService.getMessagePage(count,pageSize,beforeTime,afterTime));
   }

   @GetMapping("/id")
    public ResponseEntity updateMessageType(@PathVariable("id") int id){
       messageService.updateMessageType(id);
       return ResponseEntity.ok().build();
   }

}
