package org.shak.emailtesting.service;


import org.shak.emailtesting.entity.EmailAttributes;

/**
 * @author Mr.Shak
 */
public interface EmailService {
    String sendEMail(EmailAttributes emailAttributes);
}
