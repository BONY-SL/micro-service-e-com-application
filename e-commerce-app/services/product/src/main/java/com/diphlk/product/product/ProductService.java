package com.diphlk.product.product;

import com.diphlk.product.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    public Integer createProduct(CreateProductRequest request) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }
    public List<PurchaseProductResponse> purchaseProduct(List<PurchaseProductRequest> request) {
        var productIds = request.stream()
                .map(PurchaseProductRequest::productId)
                .toList();
        var products = productRepository.findAllByIdInOrderById(productIds);

        if (productIds.size() != products.size()) {
            throw new ProductPurchaseException("One or more products not found for the provided IDs");
        }
        var storesRequest = request
                .stream()
                .sorted(Comparator.comparing(PurchaseProductRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<PurchaseProductResponse>();

        for (int i = 0; i < storesRequest.size(); i++) {
            var storeRequest = storesRequest.get(i);
            var product = products.get(i);
            if (product.getAvailableQuantity() < storeRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock for product ID: " + storeRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - storeRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, storeRequest.quantity()));
        }
        return purchasedProducts;
    }
    public ProductResponse findProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }

    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
