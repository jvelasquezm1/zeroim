package test.osdarTest.repository.maestros.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PastoresDataRepository extends ReactiveCrudRepository<PastoresData, String> {

    Mono<PastoresData> findByIdDocument(String idDocument);

}
