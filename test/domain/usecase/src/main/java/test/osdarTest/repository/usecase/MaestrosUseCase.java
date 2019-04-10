package test.osdarTest.repository.usecase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.repository.entity.Pastores;
import test.osdarTest.repository.gateway.MaestrosRepository;

public class MaestrosUseCase {

    private MaestrosRepository maestrosRepository;

    public MaestrosUseCase(MaestrosRepository maestrosRepository) {
        this.maestrosRepository = maestrosRepository;
    }

    public Flux<Pastores> getPastores() {
        return maestrosRepository.getPastores();
    }

    public Mono<Pastores> getPastoresByIdDocument(String idDocument) {
        return maestrosRepository.getPastorByIdDocuemnt(idDocument);
    }

}
