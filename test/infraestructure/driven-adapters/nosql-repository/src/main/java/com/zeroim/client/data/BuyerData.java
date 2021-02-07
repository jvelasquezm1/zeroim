package com.zeroim.client.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Buyer")
public class BuyerData {
    @Id
    private Long idNumber;
    private Long idType;
    private String name;
    private String address;
    private String phone;
}
