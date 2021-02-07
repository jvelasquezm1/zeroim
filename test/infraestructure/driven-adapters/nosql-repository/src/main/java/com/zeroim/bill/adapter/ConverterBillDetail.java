package com.zeroim.bill.adapter;

import com.zeroim.bill.data.BillDetailData;
import com.zeroim.bill.entity.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;

@Component
public class ConverterBillDetail {
    @Autowired
    ObjectMapper mapper;

    public BillDetail toEntity(BillDetailData billDetailData) {
        return mapper.map(billDetailData, BillDetail.class);
    }

    public BillDetailData toData(BillDetail billDetail) {
        return mapper.map(billDetail, BillDetailData.class);
    }
}
