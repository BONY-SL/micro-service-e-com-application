package com.diphlk.ecommerce.kafka.order;

import com.diphlk.ecommerce.kafka.payment.PaymentMethod;
import org.springframework.data.annotation.PersistenceCreator;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        @JsonProperty("customerResponse")
        Customer customer,
        @JsonProperty("purchases")
        List<Product> products
) {
    @PersistenceCreator
    public OrderConfirmation {
    }
}
