package com.zeroim.bill.adapter;

import com.zeroim.bill.data.BillDataRepo;
import com.zeroim.bill.entity.Bill;
import com.zeroim.bill.gateway.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BillRepoAdapter implements BillRepo {
    @Autowired
    ConverterBill converterBill;
    @Autowired
    private BillDataRepo billDataRepo;

    @Override
    public Mono<Bill> create(Bill bill) {
        return Mono.just(bill)
                .map(converterBill::toData)
                .flatMap(billDataRepo::save)
                .map(converterBill::toEntity);
    }

    @Override
    public Mono<Bill> getById(Long id) {
        return billDataRepo.findById(id)
                .map(converterBill::toEntity);
    }

    @Override
    public Mono<Void> delete(Long id) {
        billDataRepo.findById(id)
                .map(billDataRepo::delete);
        return Mono.empty();
    }

    @Override
    public Flux<Bill> getAll() {
        return billDataRepo.findAll()
                .map(converterBill::toEntity);
    }
}
