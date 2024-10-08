package com.carreiras.java_spring_boot_pedidos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;


public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage message) {
        LOG.info("Simulando envio de e-mail...");
        LOG.info(message.toString());
        LOG.info("E-mail enviado.");
    }

    @Override
    public void sendHtmlEmail(MimeMessage message) {
        LOG.info("Simulando envio de e-mail HTML...");
        LOG.info(message.toString());
        LOG.info("E-mail enviado.");
    }
}
