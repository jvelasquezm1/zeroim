package com.zeroim.stock;

import com.zeroim.stock.entity.StockItem;
import com.zeroim.stock.gateway.StockItemRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StockItemUseCase {
    private final StockItemRepo stockItemRepo;

    public StockItemUseCase(StockItemRepo stockItemRepo) {
        this.stockItemRepo = stockItemRepo;
    }

    public Mono<StockItem> create(StockItem stockItem) {
        return stockItemRepo.create(stockItem);
    }

    public Mono<StockItem> getById(Long id) {
        return stockItemRepo.getById(id);
    }

    public Mono<Void> delete(Long id) {
        return stockItemRepo.delete(id);
    }

    public Flux<StockItem> getAll() {
        return stockItemRepo.getAll();
    }
}
