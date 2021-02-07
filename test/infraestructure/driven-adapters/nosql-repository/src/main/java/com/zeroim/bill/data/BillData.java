package com.zeroim.bill.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Bill")
public class BillData {
    @Id
    private Long id;
    private Date date;
    private Long clientId;
    private Long[] billDetail;
    private BigDecimal total;
}
