package com.diphlk.product.product;

public record PurchaseProductResponse (
        Integer productId,
        String name,
        String description,
        Integer quantity,
        Double price
){
}
