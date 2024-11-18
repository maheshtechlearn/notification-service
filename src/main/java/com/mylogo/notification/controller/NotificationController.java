package com.mylogo.notification.controller;

import com.mylogo.notification.dto.Notification;
import com.mylogo.notification.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;

    /**
     * Endpoint to send a notification to the recipient based on type (SMS or EMAIL).
     *
     * @param notification Notification details including type, recipient, and message.
     */
    @PostMapping
    public void sendNotification(@RequestBody Notification notification) throws Exception {
        logger.info("Received notification request for recipient: {}", notification.getRecipient());
        notificationService.sendNotification(notification);
    }
}
