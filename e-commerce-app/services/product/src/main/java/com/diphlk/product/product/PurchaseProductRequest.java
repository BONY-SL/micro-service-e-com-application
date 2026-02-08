package com.diphlk.product.product;

import jakarta.validation.constraints.NotNull;

public record PurchaseProductRequest (
        @NotNull(message = "Product ID is required")
        Integer productId,
        @NotNull(message = "Quantity is required")
        Integer quantity
){
}
