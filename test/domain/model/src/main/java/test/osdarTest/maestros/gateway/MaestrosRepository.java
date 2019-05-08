package test.osdarTest.maestros.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.*;

public interface MaestrosRepository {

    Flux<Pastor> getPastores();

    Mono<Pastor> getPastorByCedula(String cedula);

    Mono<Pastor> savePastor(Pastor pastor);

    Flux<Iglesia> getIglesias();

    Mono<Iglesia> getIglesiaByName(String name);

    Mono<Iglesia> saveIglesia(Iglesia iglesia);

    Flux<Notaria> getNotarias();

    Mono<Notaria> getNotariaByName(String name);

    Flux<DocumentoIdentidad> getDocumentosIdentidad();

    Mono<DocumentoIdentidad> getDocumentoIdentidadByName(String name);

    Mono<DocumentoIdentidad> getDocumentoIdentidadByIdType(String idType);

}
