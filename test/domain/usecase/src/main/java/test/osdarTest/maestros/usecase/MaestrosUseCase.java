package test.osdarTest.maestros.usecase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.gateway.MaestrosRepository;

public class MaestrosUseCase {

    private MaestrosRepository maestrosRepository;

    public MaestrosUseCase(MaestrosRepository maestrosRepository) {
        this.maestrosRepository = maestrosRepository;
    }

    public Flux<Pastor> getPastores() {
        return maestrosRepository.getPastores();
    }

    public Mono<Pastor> getPastorByIdDocument(String idDocument) {
        return maestrosRepository.getPastorByIdDocuemnt(idDocument);
    }

    public Flux<Iglesia> getIglesias() {
        return maestrosRepository.getIglesias();
    }

    public Mono<Iglesia> getIglesiasByName(String name) {
        return maestrosRepository.getIglesiaByName(name);
    }

}
