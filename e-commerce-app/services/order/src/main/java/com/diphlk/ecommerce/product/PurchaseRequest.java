package com.diphlk.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product ID cannot be null")
        Integer productId,
        @NotNull(message = "Quantity cannot be null")
        @Positive(message = "Quantity must be greater than zero")
        double quantity
) {
}
