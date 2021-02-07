package com.zeroim.web;

import com.zeroim.client.IdTypeUseCase;
import com.zeroim.client.entity.IdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(value = "*")
public class IdTypeController {
    @Autowired
    private IdTypeUseCase idTypeUseCase;

    @PostMapping(value = "/idType")
    public Mono<IdType> create(IdType idType) {
        return idTypeUseCase.create(idType);
    }

    @GetMapping(value = "/idType/{id}")
    public Mono<IdType> getById(@PathVariable Long id) {
        return idTypeUseCase.getById(id);
    }

    @DeleteMapping(value = "/idType/delete/{id}")
    public Mono<Void> delete(Long id) {
        return idTypeUseCase.delete(id);
    }

    @GetMapping(value = "/idType/getAll")
    public Flux<IdType> getAll() {
        return idTypeUseCase.getAll();
    }
}
