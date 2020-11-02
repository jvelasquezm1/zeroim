package com.zeroim.product.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.zeroim.product.entity.Product;

public interface ProductRepository {
    Mono<Product> createProduct(Product product);
    Mono<Product> getProductById(String id);

    Flux<Product> getProducts();
}
