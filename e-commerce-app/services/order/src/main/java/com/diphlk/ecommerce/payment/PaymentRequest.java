package com.diphlk.ecommerce.payment;

import com.diphlk.ecommerce.customer.CustomerResponse;
import com.diphlk.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
