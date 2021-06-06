package com.stefanmilojevic.myRealEstate.controller;

import com.stefanmilojevic.myRealEstate.dto.NotificationDTO;
import com.stefanmilojevic.myRealEstate.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/notifications")
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/getNumber")
    public ResponseEntity<Integer> getNumOfNotSeen(HttpServletRequest request) {
        return ResponseEntity.ok(notificationService.getNum(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<NotificationDTO>> getAll(HttpServletRequest request) {
        return ResponseEntity.ok(notificationService.getAll(request));
    }
}
