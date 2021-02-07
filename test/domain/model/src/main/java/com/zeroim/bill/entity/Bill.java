package com.zeroim.bill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill {
    private Long id;
    private Date date;
    private Long clientId;
    private Long[] billDetail;
    private BigDecimal total;
}
