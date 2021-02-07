package com.zeroim.bill.adapter;

import com.zeroim.bill.data.BillData;
import com.zeroim.bill.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;

@Component
public class ConverterBill {
    @Autowired
    ObjectMapper mapper;

    public Bill toEntity(BillData billData) {
        return mapper.map(billData, Bill.class);
    }

    public BillData toData(Bill bill) {
        return mapper.map(bill, BillData.class);
    }
}
