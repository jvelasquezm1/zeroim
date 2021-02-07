package com.zeroim.client.adapter;

import com.zeroim.client.data.IdTypeDataRepo;
import com.zeroim.client.entity.IdType;
import com.zeroim.client.gateway.IdTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class IdTypeRepoAdapter implements IdTypeRepo {
    @Autowired
    ConverterIdType converterIdType;
    @Autowired
    private IdTypeDataRepo idTypeDataRepo;

    @Override
    public Mono<IdType> create(IdType idType) {
        return Mono.just(idType)
                .map(converterIdType::toData)
                .flatMap(idTypeDataRepo::save)
                .map(converterIdType::toEntity);
    }

    @Override
    public Mono<IdType> getById(Long id) {
        return idTypeDataRepo.findById(id)
                .map(converterIdType::toEntity);
    }

    @Override
    public Mono<Void> delete(Long id) {
        idTypeDataRepo.findById(id)
                .map(idTypeDataRepo::delete);
        return Mono.empty();
    }

    @Override
    public Flux<IdType> getAll() {
        return idTypeDataRepo.findAll()
                .map(converterIdType::toEntity);
    }
}
