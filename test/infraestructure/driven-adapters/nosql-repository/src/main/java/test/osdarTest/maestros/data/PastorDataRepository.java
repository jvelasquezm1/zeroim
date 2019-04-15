package test.osdarTest.maestros.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PastorDataRepository extends ReactiveCrudRepository<PastorData, String> {

    Mono<PastorData> getPastorByCedula(String cedula);

}
