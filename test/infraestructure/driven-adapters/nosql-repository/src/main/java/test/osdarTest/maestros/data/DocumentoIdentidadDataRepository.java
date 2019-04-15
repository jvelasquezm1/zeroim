package test.osdarTest.maestros.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import javax.print.Doc;

public interface DocumentoIdentidadDataRepository extends ReactiveCrudRepository<DocumentoIdentidadData, String> {

    Mono<DocumentoIdentidadData> findByName(String name);

    Mono<DocumentoIdentidadData> findByIdType(String idType);

}
