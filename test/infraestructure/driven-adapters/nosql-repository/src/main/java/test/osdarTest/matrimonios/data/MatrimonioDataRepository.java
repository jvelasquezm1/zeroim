package test.osdarTest.matrimonios.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MatrimonioDataRepository extends ReactiveCrudRepository<MatrimonioData, String> {

    Flux<MatrimonioData> findByPastor_Names(String namePastor);

    Flux<MatrimonioData> findByIglesia_Name(String nameIglesia);

}
