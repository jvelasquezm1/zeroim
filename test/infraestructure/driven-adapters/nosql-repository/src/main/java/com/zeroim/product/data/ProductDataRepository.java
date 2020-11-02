package com.zeroim.product.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductDataRepository extends ReactiveCrudRepository<ProductData, String> {}
