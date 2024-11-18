package com.mylogo.notification.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

    /**
     * Sends an SMS to the specified recipient.
     * @param recipient The phone number of the recipient.
     * @param message The message content of the SMS.
     */
    public void sendSms(String recipient, String message) {
        logger.info("Sending SMS to {}: {}", recipient, message);
        // Add actual SMS sending logic here (e.g., using an SMS provider API).
    }
}
