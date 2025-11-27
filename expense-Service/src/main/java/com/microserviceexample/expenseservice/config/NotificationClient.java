package com.microserviceexample.expenseservice.config;

import com.microserviceexample.expenseservice.entity.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificationClient",url = "${notificationurl}")
public interface NotificationClient {

    @PostMapping()
    Notification createNotification(@RequestBody Notification notification);
}
