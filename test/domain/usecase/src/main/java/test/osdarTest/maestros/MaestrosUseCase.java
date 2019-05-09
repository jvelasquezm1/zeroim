package test.osdarTest.maestros;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Iglesia;
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

    public Mono<Pastor> savePastor(Pastor pastor) {
        return maestrosRepository.savePastor(pastor);
    }

    public Flux<Iglesia> getIglesias() {
        return maestrosRepository.getIglesias();
    }

    public Mono<Iglesia> getIglesiasByName(String name) {
        return maestrosRepository.getIglesiaByName(name);
    }

    public Mono<Iglesia> saveIglesia(Iglesia iglesia) {
        return maestrosRepository.saveIglesia(iglesia);
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
