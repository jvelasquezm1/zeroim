package com.zeroim.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdType {
    private Long id;
    private String abbreviation;
    private String name;
}
