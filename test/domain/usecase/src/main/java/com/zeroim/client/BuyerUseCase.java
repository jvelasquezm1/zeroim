package com.zeroim.client;

import com.zeroim.client.entity.Buyer;
import com.zeroim.client.gateway.BuyerRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BuyerUseCase {
    private final BuyerRepo buyerRepo;

    public BuyerUseCase(BuyerRepo buyerRepo) {
        this.buyerRepo = buyerRepo;
    }

    public Mono<Buyer> create(Buyer buyer) {
        return buyerRepo.create(buyer);
    }

    public Mono<Buyer> getById(Long buyerId) {
        return buyerRepo.getById(buyerId);
    }

    public Mono<Void> delete(Long buyerId) {
        return buyerRepo.delete(buyerId);
    }

    public Flux<Buyer> getAll() {
        return buyerRepo.getAll();
    }
}
