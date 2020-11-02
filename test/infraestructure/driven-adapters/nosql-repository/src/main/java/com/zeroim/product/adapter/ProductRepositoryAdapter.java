package com.zeroim.product.adapter;

import com.zeroim.product.data.ProductDataRepository;
import com.zeroim.product.entity.Product;
import com.zeroim.product.gateway.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {
    @Autowired
    ConverterProduct converter;

    @Autowired
    private ProductDataRepository productDataRepository;

    @Override
    public Mono<Product> createProduct(Product product) {
        return Mono.just(product)
                .map(converter::toData)
                .flatMap(productDataRepository::save)
                .map(converter::toEntity);
    }

    @Override
    public Mono<Product> getProductById(String id) {
        return productDataRepository.findById(id)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Product> getProducts() {
        return productDataRepository.findAll()
                .map(converter::toEntity);
    }
}
