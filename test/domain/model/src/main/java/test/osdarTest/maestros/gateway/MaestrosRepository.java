package test.osdarTest.maestros.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Pastor;

public interface MaestrosRepository {

    Flux<Pastor> getPastores();

    Mono<Pastor> getPastorByIdDocuemnt(String idDocument);

    Flux<Iglesia> getIglesias();

    Mono<Iglesia> getIglesiaByName(String name);

}
