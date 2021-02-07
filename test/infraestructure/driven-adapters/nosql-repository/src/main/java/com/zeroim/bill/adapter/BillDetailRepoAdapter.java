package com.zeroim.bill.adapter;

import com.zeroim.bill.data.BillDetailDataRepo;
import com.zeroim.bill.entity.BillDetail;
import com.zeroim.bill.gateway.BillDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BillDetailRepoAdapter implements BillDetailRepo {
    @Autowired
    ConverterBillDetail converterBillDetail;
    @Autowired
    private BillDetailDataRepo billDetailDataRepo;

    @Override
    public Mono<BillDetail> create(BillDetail billDetail) {
        return Mono.just(billDetail)
                .map(converterBillDetail::toData)
                .flatMap(billDetailDataRepo::save)
                .map(converterBillDetail::toEntity);
    }

    @Override
    public Mono<BillDetail> getById(Long id) {
        return billDetailDataRepo.findById(id)
                .map(converterBillDetail::toEntity);
    }

    @Override
    public Mono<Void> delete(Long id) {
        billDetailDataRepo.findById(id)
                .map(billDetailDataRepo::delete);
        return Mono.empty();
    }

    @Override
    public Flux<BillDetail> getAll() {
        return billDetailDataRepo.findAll()
                .map(converterBillDetail::toEntity);
    }
}
