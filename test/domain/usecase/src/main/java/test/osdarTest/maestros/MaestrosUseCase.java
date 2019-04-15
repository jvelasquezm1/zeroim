package test.osdarTest.maestros;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Notaria;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.gateway.MaestrosRepository;

public class MaestrosUseCase {

    private MaestrosRepository maestrosRepository;

    public MaestrosUseCase(MaestrosRepository maestrosRepository) {
        this.maestrosRepository = maestrosRepository;
    }

    public Flux<Pastor> getPastores() {
        return maestrosRepository.getPastores();
    }

    public Mono<Pastor> getPastorByIdDocument(String cedula) {
        return maestrosRepository.getPastorByCedula(cedula);
    }

    public Flux<Iglesia> getIglesias() {
        return maestrosRepository.getIglesias();
    }

    public Mono<Iglesia> getIglesiasByName(String name) {
        return maestrosRepository.getIglesiaByName(name);
    }

    public Flux<Notaria> getNotarias(){
        return maestrosRepository.getNotarias();
    }

    public Mono<Notaria> getNotariaByName(String name){
        return maestrosRepository.getNotariaByName(name);
    }

    public Flux<DocumentoIdentidad> getDocumentosIdentidad() {
        return maestrosRepository.getDocumentosIdentidad();
    }

    public Mono<DocumentoIdentidad> getDocumentoIdentidadByName(String name) {
        return maestrosRepository.getDocumentoIdentidadByName(name);
    }

    public Mono<DocumentoIdentidad> getDocumentoIdentidadByIdType(String idType) {
        return maestrosRepository.getDocumentoIdentidadByIdType(idType);
    }

}
