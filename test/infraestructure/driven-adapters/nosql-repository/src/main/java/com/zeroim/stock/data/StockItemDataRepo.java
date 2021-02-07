package com.zeroim.stock.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StockItemDataRepo extends ReactiveCrudRepository<StockItemData, Long> {
}
