package com.zeroim.bill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillDetail {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal value;
}
