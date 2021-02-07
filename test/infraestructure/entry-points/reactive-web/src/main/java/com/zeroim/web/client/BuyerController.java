package com.zeroim.web.client;

import com.zeroim.client.BuyerUseCase;
import com.zeroim.client.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController(value = "/buyer")
@CrossOrigin(value = "*")
public class BuyerController {
    @Autowired
    private BuyerUseCase buyerUseCase;

    @PostMapping
    public Mono<Buyer> create(Buyer buyer) {
        return buyerUseCase.create(buyer);
    }

    @GetMapping(value = "/{id}")
    public Mono<Buyer> getById(@PathVariable Long id) {
        return buyerUseCase.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return buyerUseCase.delete(id);
    }

    @GetMapping(value = "/getAll")
    public Flux<Buyer> getAll() {
        return buyerUseCase.getAll();
    }
}
