package com.zeroim.stock.adapter;

import com.zeroim.stock.data.StockItemDataRepo;
import com.zeroim.stock.entity.StockItem;
import com.zeroim.stock.gateway.StockItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class StockItemRepoAdapter implements StockItemRepo {
    @Autowired
    ConverterStockItem converterStockItem;
    @Autowired
    private StockItemDataRepo stockItemDataRepo;

    @Override
    public Mono<StockItem> create(StockItem stockItem) {
        return Mono.just(stockItem)
                .map(converterStockItem::toData)
                .flatMap(stockItemDataRepo::save)
                .map(converterStockItem::toEntity);
    }

    @Override
    public Mono<StockItem> getById(Long id) {
        return stockItemDataRepo.findById(id)
                .map(converterStockItem::toEntity);
    }

    @Override
    public Mono<Void> delete(Long id) {
        stockItemDataRepo.findById(id)
                .map(stockItemDataRepo::delete);
        return Mono.empty();
    }

    @Override
    public Flux<StockItem> getAll() {
        return stockItemDataRepo.findAll()
                .map(converterStockItem::toEntity);
    }
}
