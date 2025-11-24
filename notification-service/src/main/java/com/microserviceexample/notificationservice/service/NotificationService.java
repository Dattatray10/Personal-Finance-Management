package com.microserviceexample.notificationservice.service;

import com.microserviceexample.notificationservice.entity.Notification;
import com.microserviceexample.notificationservice.repository.NotificationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationInterface notificationrepo;

    public List<Notification> getAllNotification() {

        return notificationrepo.findAll();
    }

    public Notification create(Notification notification) {

        return notificationrepo.save(notification);
    }
}
