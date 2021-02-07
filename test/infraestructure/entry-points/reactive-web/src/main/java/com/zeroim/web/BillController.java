package com.zeroim.web;

import com.zeroim.bill.BillUseCase;
import com.zeroim.bill.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(value = "*")
public class BillController {
    @Autowired
    private BillUseCase billUseCase;

    @PostMapping(value = "/bill")
    public Mono<Bill> create(Bill bill) {
        return billUseCase.create(bill);
    }

    @GetMapping(value = "/bill/{id}")
    public Mono<Bill> getById(@PathVariable Long id) {
        return billUseCase.getById(id);
    }

    @DeleteMapping(value = "/bill/delete/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return billUseCase.delete(id);
    }

    @GetMapping(value = "/bill/getAll")
    public Flux<Bill> getAll() {
        return billUseCase.getAll();
    }
}
