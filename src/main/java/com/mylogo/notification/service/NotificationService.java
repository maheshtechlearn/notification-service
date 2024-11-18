package com.mylogo.notification.service;


import com.mylogo.notification.dto.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    /**
     * Processes the notification by sending an SMS or Email based on the type specified.
     * @param notification The notification object containing recipient, message, and type.
     */
    public void sendNotification(Notification notification) throws Exception {
        logger.info("Processing notification for recipient: {}", notification.getRecipient());

        if ("EMAIL".equalsIgnoreCase(notification.getType())) {
            emailService.sendEmail(notification.getRecipient(), notification.getMessage());
        } else if ("SMS".equalsIgnoreCase(notification.getType())) {
            smsService.sendSms(notification.getRecipient(), notification.getMessage());
        } else {
            logger.warn("Invalid notification type: {}. Supported types are EMAIL and SMS.", notification.getType());
        }
    }
}
