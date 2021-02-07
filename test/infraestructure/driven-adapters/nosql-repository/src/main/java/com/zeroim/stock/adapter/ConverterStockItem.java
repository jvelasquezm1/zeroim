package com.zeroim.stock.adapter;

import com.zeroim.stock.data.StockItemData;
import com.zeroim.stock.entity.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;

@Component
public class ConverterStockItem {
    @Autowired
    ObjectMapper mapper;

    public StockItem toEntity(StockItemData stockItemData) {
        return mapper.map(stockItemData, StockItem.class);
    }

    public StockItemData toData(StockItem stockItem) {
        return mapper.map(stockItem, StockItemData.class);
    }
}
