package test.osdarTest.maestros.data;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface NotariaDataRepository extends ReactiveCrudRepository<NotariaData, String> {

    @Query(value = "{'name': {$regex : '^?0$', $options: 'i'}}")
    Mono<NotariaData> findByNameMatchesRegex(String name);

}
