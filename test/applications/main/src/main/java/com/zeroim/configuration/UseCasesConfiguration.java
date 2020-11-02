package com.zeroim.configuration;

import com.zeroim.product.ProductUseCase;
import com.zeroim.product.gateway.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public ProductUseCase productUseCase(ProductRepository productRepository) {
        return new ProductUseCase(productRepository);
    }

}
