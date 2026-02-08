package com.diphlk.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateProductRequest (
         Integer id,
         @NotNull(message = "Product name is required")
         String name,
         @NotNull(message = "Product description is required")
         String description,
         @Positive(message = "Available quantity must be positive")
         Double availableQuantity,
         @Positive(message = "Price must be positive")
         BigDecimal price,
         @NotNull(message = "Category ID is required")
         Integer categoryId
){
}
