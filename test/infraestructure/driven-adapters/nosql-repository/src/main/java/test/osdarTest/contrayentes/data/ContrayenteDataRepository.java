package test.osdarTest.contrayentes.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ContrayenteDataRepository extends ReactiveCrudRepository<ContrayenteData, String> {

    Mono<ContrayenteData> getByDocumentNumber(String documentNumber);

}
