package com.zeroim.product;

import com.zeroim.product.entity.Product;
import com.zeroim.product.gateway.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductUseCase {
    private final ProductRepository productRepository;
    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> saveProduct(Product product) {
        return productRepository.createProduct(product);
    }

    public Flux<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public Mono<Product> getProductById(String id) {
        return productRepository.getProductById(id);
    }
}
