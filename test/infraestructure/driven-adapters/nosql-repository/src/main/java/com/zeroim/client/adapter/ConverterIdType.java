package com.zeroim.client.adapter;

import com.zeroim.client.data.IdTypeData;
import com.zeroim.client.entity.IdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;

@Component
public class ConverterIdType {
    @Autowired
    ObjectMapper mapper;

    public IdType toEntity(IdTypeData idTypeData) {
        return mapper.map(idTypeData, IdType.class);
    }

    public IdTypeData toData(IdType idType) {
        return mapper.map(idType, IdTypeData.class);
    }
}
