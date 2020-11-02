package com.zeroim.product.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Product")
public class ProductData {
    @Id
    private String id;
    private String name;
    private float price;
    private String sku;
    private String description;
    private String image;
}
