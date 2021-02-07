package com.zeroim.client.adapter;

import com.zeroim.client.data.BuyerDataRepo;
import com.zeroim.client.entity.Buyer;
import com.zeroim.client.gateway.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BuyerRepoAdapter implements BuyerRepo {
    @Autowired
    ConverterBuyer converterBuyer;
    @Autowired
    private BuyerDataRepo buyerDataRepo;

    @Override
    public Mono<Buyer> create(Buyer buyer) {
        return Mono.just(buyer)
                .map(converterBuyer::toData)
                .flatMap(buyerDataRepo::save)
                .map(converterBuyer::toEntity);
    }

    @Override
    public Mono<Buyer> getById(Long buyerId) {
        return buyerDataRepo.findById(buyerId)
                .map(converterBuyer::toEntity);
    }

    @Override
    public Mono<Void> delete(Long buyerId) {
        buyerDataRepo.findById(buyerId)
                .map(buyerDataRepo::delete);
        return Mono.empty();
    }

    @Override
    public Flux<Buyer> getAll() {
        return buyerDataRepo.findAll()
                .map(converterBuyer::toEntity);
    }
}
