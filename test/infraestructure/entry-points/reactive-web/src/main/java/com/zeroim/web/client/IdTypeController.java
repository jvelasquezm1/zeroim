package com.zeroim.web.client;

import com.zeroim.client.IdTypeUseCase;
import com.zeroim.client.entity.IdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController(value = "/idType")
@CrossOrigin(value = "*")
public class IdTypeController {
    @Autowired
    private IdTypeUseCase idTypeUseCase;

    @PostMapping
    public Mono<IdType> create(IdType idType) {
        return idTypeUseCase.create(idType);
    }

    @GetMapping(value = "/{id}")
    public Mono<IdType> getById(@PathVariable Long id) {
        return idTypeUseCase.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(Long id) {
        return idTypeUseCase.delete(id);
    }

    @GetMapping(value = "/getAll")
    public Flux<IdType> getAll() {
        return idTypeUseCase.getAll();
    }
}
