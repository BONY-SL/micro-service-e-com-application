package com.diphlk.ecommerce.kafka.payment;

import org.springframework.data.annotation.PersistenceCreator;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
    @PersistenceCreator
    public PaymentConfirmation {
    }
}
