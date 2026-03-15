package com.diphlk.ecommerce.cnfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender(){
        return null;

    }
}
