package com.microserviceexample.notificationservice.controller;


import com.microserviceexample.notificationservice.entity.Notification;
import com.microserviceexample.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getAll")
    public List<Notification> findAll() {

        return notificationService.getAllNotification();
    }


    @PostMapping("/create")
    public Notification createNotification(@RequestBody Notification notification) {

        return notificationService.create(notification);
    }



}
