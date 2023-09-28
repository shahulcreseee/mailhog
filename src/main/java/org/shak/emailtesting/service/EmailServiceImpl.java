package org.shak.emailtesting.service;

import org.shak.emailtesting.entity.EmailAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Shak
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String emailSender;
    @Override
    public String sendEMail(EmailAttributes emailAttributes) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(emailSender);
            mailMessage.setTo(emailAttributes.getRecipient());
            mailMessage.setSubject(emailAttributes.getSubject());
            mailMessage.setText(emailAttributes.getBody());
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Email is sent successfully to"+emailAttributes.getRecipient() ;
        }
        catch (Exception e) {
            return "Error while Sending the Email";
        }
    }
}
