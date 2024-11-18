package com.mylogo.notification.service;


import com.mylogo.notification.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * Sends an email to the specified recipient with the given message.
     *
     * @param recipient the email address of the recipient
     * @param message   the message to be sent
     */
    public void sendEmail(String recipient, String message) throws Exception {
        logger.info("Preparing to send email to {}", recipient);

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(recipient);
            mailMessage.setSubject("Test Email from Spring Boot App");
            mailMessage.setText(message);

            logger.debug("Email details: From: {}, To: {}, Subject: {}, Message: {}", sender, recipient, mailMessage.getSubject(), message);

            javaMailSender.send(mailMessage);
            logger.info("Email sent successfully to {}", recipient);
        } catch (Exception e) {
            logger.error("Error while sending email to {}: {}", recipient, e.getMessage(), e);
            throw new Exception("Error while Sending Mail ", e);
        }
    }
}
