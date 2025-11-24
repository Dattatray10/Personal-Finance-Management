package com.microserviceexample.notificationservice.repository;

import com.microserviceexample.notificationservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository
        ;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationInterface extends JpaRepository<Notification,Long> {

}
