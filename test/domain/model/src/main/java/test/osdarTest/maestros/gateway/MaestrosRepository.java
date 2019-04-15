package test.osdarTest.maestros.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Notaria;
import test.osdarTest.maestros.entity.Pastor;

public interface MaestrosRepository {

    Flux<Pastor> getPastores();

    Mono<Pastor> getPastorByCedula(String cedula);

    Flux<Iglesia> getIglesias();

    Mono<Iglesia> getIglesiaByName(String name);

    Flux<Notaria> getNotarias();

    Mono<Notaria> getNotariaByName(String name);

    Flux<DocumentoIdentidad> getDocumentosIdentidad();

    Mono<DocumentoIdentidad> getDocumentoIdentidadByName(String name);

    Mono<DocumentoIdentidad> getDocumentoIdentidadByIdType(String idType);

}
