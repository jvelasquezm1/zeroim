package com.zeroim.client.adapter;

import com.zeroim.client.data.BuyerData;
import com.zeroim.client.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;

@Component
public class ConverterBuyer {
    @Autowired
    ObjectMapper mapper;

    public Buyer toEntity(BuyerData clientData) {
        return mapper.map(clientData, Buyer.class);
    }

    public BuyerData toData(Buyer client) {
        return mapper.map(client, BuyerData.class);
    }
}
