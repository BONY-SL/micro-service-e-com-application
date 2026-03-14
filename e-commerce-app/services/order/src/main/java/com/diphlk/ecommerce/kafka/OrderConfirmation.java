package com.diphlk.ecommerce.kafka;

import com.diphlk.ecommerce.customer.CustomerResponse;
import com.diphlk.ecommerce.order.PaymentMethod;
import com.diphlk.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> purchases
) {
}
