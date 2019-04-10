package test.osdarTest.repository.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.repository.entity.Pastores;

public interface MaestrosRepository {

    Flux<Pastores> getPastores();

    Mono<Pastores> getPastorByIdDocuemnt(String idDocument);

}
