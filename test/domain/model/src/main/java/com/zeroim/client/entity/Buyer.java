package com.zeroim.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Buyer {
    private Long idNumber;
    private Long idType;
    private String name;
    private String address;
    private String phone;
}
