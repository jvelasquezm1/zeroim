package com.zeroim.bill.gateway;

import com.zeroim.bill.entity.Bill;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillRepo {
    Mono<Bill> create(Bill bill);
    Mono<Bill> getById(Long id);
    Mono<Void> delete(Long id);

    Flux<Bill> getAll();
}
