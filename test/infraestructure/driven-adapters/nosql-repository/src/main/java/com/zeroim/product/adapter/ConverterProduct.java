package com.zeroim.product.adapter;

import com.zeroim.product.data.ProductData;
import com.zeroim.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;

@Component
public class ConverterProduct {
    @Autowired
    ObjectMapper mapper;

    public Product toEntity(ProductData productData) {
        return mapper.map(productData, Product.class);
    }

    public ProductData toData(Product product) {
        return mapper.map(product, ProductData.class);
    }
}
