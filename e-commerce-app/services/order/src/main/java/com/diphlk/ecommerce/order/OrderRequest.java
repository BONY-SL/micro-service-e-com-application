package com.diphlk.ecommerce.order;

import com.diphlk.ecommerce.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(

        Integer id,
        String reference,
        @Positive(message = "Oder amount must be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method is required")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer ID is required")
        @NotEmpty(message = "Customer ID cannot be empty")
        @NotBlank(message = "Customer ID cannot be blank")
        String customerId,
        @NotEmpty(message = "Products list cannot be empty")
        List<PurchaseRequest> products
) {
}
