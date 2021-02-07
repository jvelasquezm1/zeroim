package com.zeroim.bill;

import com.zeroim.bill.entity.Bill;
import com.zeroim.bill.gateway.BillRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BillUseCase {
    private final BillRepo billRepo;

    public BillUseCase(BillRepo billRepo) {
        this.billRepo = billRepo;
    }

    public Mono<Bill> create(Bill bill) {
        return billRepo.create(bill);
    }

    public Mono<Bill> getById(Long id) {
        return billRepo.getById(id);
    }

    public Mono<Void> delete(Long id) {
        return billRepo.delete(id);
    }

    public Flux<Bill> getAll() {
        return billRepo.getAll();
    }
}
