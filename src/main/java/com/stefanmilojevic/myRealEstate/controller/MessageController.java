package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.model.Message;
import com.stefanmilojevic.myRealEstate.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/messages")
@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/getAllForLogged")
    public ResponseEntity<List<Message>> getByAdvertIdForLogged(HttpServletRequest request) {
        return ResponseEntity.ok(messageService.getAllByLogged(request));
    }

    @PostMapping()
    public ResponseEntity<List<Message>> save(@RequestBody Message message, HttpServletRequest request) {
        return ResponseEntity.ok(messageService.save(message, request));
    }

    @PutMapping("markAsSeen")
    public ResponseEntity<String> save(@RequestBody List<Message> messages) {
        return ResponseEntity.ok(messageService.markAsSeen(messages));
    }

    @GetMapping("/getNotSeenNum")
    public ResponseEntity<Integer> getNumOfNotSeen(HttpServletRequest request) {
        return ResponseEntity.ok(messageService.getNumOfNotSeen(request));
    }
}
