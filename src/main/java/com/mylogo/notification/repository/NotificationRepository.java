package com.mylogo.notification.repository;


import com.mylogo.notification.dto.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Additional query methods can be defined here
}

