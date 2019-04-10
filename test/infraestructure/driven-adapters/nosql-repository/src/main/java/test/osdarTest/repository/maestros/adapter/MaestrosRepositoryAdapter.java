package test.osdarTest.repository.maestros.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.repository.entity.Pastores;
import test.osdarTest.repository.gateway.MaestrosRepository;
import test.osdarTest.repository.maestros.data.PastoresDataRepository;

@Repository
public class MaestrosRepositoryAdapter implements MaestrosRepository {

    @Autowired
    private ConverterMaestros converter;

    @Autowired
    private PastoresDataRepository pastoresDataRepository;

    @Override
    public Flux<Pastores> getPastores() {
        return pastoresDataRepository.findAll().map(converter::toEntity);
    }

    @Override
    public Mono<Pastores> getPastorByIdDocuemnt(String idDocument) {
        return pastoresDataRepository.findByIdDocument(idDocument)
                .map(converter::toEntity);
    }
}
