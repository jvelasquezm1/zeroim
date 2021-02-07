package com.zeroim.web;

import com.zeroim.product.ProductUseCase;
import com.zeroim.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(value = "*")
public class ProductController {

    @Autowired
    private ProductUseCase productUseCase;

    @PostMapping("/product/new")
    public Mono<Product> saveProduct(@RequestBody Product product) {
        return productUseCase.saveProduct(product);
    }

    @GetMapping("/products")
    public Flux<Product> getAllProducts() {
        return productUseCase.getAllProducts();
    }

    @GetMapping("product/{Id}")
    public Mono<Product> getProductById(@PathVariable String Id) {
        return productUseCase.getProductById(Id);
    }

}
