package com.zeroim.web;

import com.zeroim.stock.StockItemUseCase;
import com.zeroim.stock.entity.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController(value = "/stock")
@CrossOrigin(value = "*")
public class StockController {
    @Autowired
    private StockItemUseCase stockItemUseCase;

    @PostMapping
    public Mono<StockItem> create(StockItem stockItem) {
        return stockItemUseCase.create(stockItem);
    }

    @GetMapping(value = "/{id}")
    public Mono<StockItem> getById(@PathVariable Long id) {
        return stockItemUseCase.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return stockItemUseCase.delete(id);
    }

    @GetMapping(value = "/getAll")
    public Flux<StockItem> getAll() {
        return stockItemUseCase.getAll();
    }
}
