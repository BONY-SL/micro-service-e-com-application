package com.diphlk.product.product;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Integer availableQuantity,
        Double price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
