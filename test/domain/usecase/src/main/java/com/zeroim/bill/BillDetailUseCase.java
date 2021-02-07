package com.zeroim.bill;

import com.zeroim.bill.entity.BillDetail;
import com.zeroim.bill.gateway.BillDetailRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BillDetailUseCase {
    private final BillDetailRepo billDetailRepo;

    public BillDetailUseCase(BillDetailRepo billDetailRepo) {
        this.billDetailRepo = billDetailRepo;
    }

    public Mono<BillDetail> create(BillDetail billDetail) {
        return billDetailRepo.create(billDetail);
    }

    public Mono<BillDetail> getById(Long id) {
        return billDetailRepo.getById(id);
    }

    public Mono<Void> delete(Long id) {
        return billDetailRepo.delete(id);
    }

    public Flux<BillDetail> getAll() {
        return billDetailRepo.getAll();
    }
}
