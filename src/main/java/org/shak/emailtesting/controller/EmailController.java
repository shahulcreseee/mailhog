package org.shak.emailtesting.controller;

import org.shak.emailtesting.entity.EmailAttributes;
import org.shak.emailtesting.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Shak
 */
@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendMail(@RequestBody EmailAttributes emailAttributes)
    {
        return emailService.sendEMail(emailAttributes);
    }
}
