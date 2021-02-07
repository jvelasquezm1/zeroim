package com.zeroim.web;

import com.zeroim.client.BuyerUseCase;
import com.zeroim.client.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(value = "*")
public class BuyerController {
    @Autowired
    private BuyerUseCase buyerUseCase;

    @PostMapping(value = "/buyer")
    public Mono<Buyer> create(Buyer buyer) {
        return buyerUseCase.create(buyer);
    }

    @GetMapping(value = "/buyer/{id}")
    public Mono<Buyer> getById(@PathVariable Long id) {
        return buyerUseCase.getById(id);
    }

    @DeleteMapping(value = "/buyer/delete/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return buyerUseCase.delete(id);
    }

    @GetMapping(value = "/buyer/getAll")
    public Flux<Buyer> getAll() {
        return buyerUseCase.getAll();
    }
}
