package com.zeroim.client;

import com.zeroim.client.entity.IdType;
import com.zeroim.client.gateway.IdTypeRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class IdTypeUseCase {
    private final IdTypeRepo idTypeRepo;

    public IdTypeUseCase(IdTypeRepo idTypeRepo) {
        this.idTypeRepo = idTypeRepo;
    }

    public Mono<IdType> create(IdType idType) {
        return idTypeRepo.create(idType);
    }

    public Mono<IdType> getById(Long id) {
        return idTypeRepo.getById(id);
    }

    public Mono<Void> delete(Long id) {
        return idTypeRepo.delete(id);
    }

    public Flux<IdType> getAll() {
        return idTypeRepo.getAll();
    }
}
