package com.diphlk.product.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid CreateProductRequest request
    ){
        return ResponseEntity.ok(productService.createProduct(request));

    }
    @PostMapping("/purchase")
    public ResponseEntity<List<PurchaseProductResponse>> purchaseProduct(
            @RequestBody List<PurchaseProductRequest> request
    ){
        return ResponseEntity.ok(productService.purchaseProduct(request));

    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(productService.findProductById(productId));

    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
