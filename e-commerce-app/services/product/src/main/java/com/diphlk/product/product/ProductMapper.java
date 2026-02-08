package com.diphlk.product.product;

import com.diphlk.product.category.Category;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(CreateProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(
                        Category.builder()
                                .id(request.categoryId())
                                .build()
                )
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity().intValue(),
                product.getPrice().doubleValue(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public PurchaseProductResponse toProductPurchaseResponse(Product product, Integer quantity) {
        return new PurchaseProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                quantity,
                product.getPrice().doubleValue()
        );
    }
}
