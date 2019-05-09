package test.osdarTest.maestros.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.*;
import test.osdarTest.maestros.data.*;
import test.osdarTest.maestros.entity.*;
import test.osdarTest.maestros.gateway.MaestrosRepository;

@Repository
public class MaestrosRepositoryAdapter implements MaestrosRepository {

    @Autowired
    private ConverterMaestros converter;

    @Autowired
    private PastorDataRepository pastorDataRepository;

    @Autowired
    private IglesiaDataRepository iglesiaDataRepository;

    @Autowired
    private DocumentoIdentidadDataRepository documentoIdentidadDataRepository;

    @Override
    public Flux<Pastor> getPastores() {
        return pastorDataRepository.findAll().map(converter::toEntity);
    }

    @Override
    public Mono<Pastor> getPastorByCedula(String cedula) {
        return pastorDataRepository.getPastorByDocumentNumber(cedula)
                .map(converter::toEntity);
    }

    @Override
    public Mono<Pastor> savePastor(Pastor pastor) {
        return Mono.just(pastor)
                .map(converter::toData)
                .flatMap(pastorDataRepository::save)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Iglesia> getIglesias() {
        return iglesiaDataRepository.findAll()
                .map(converter::toEntity);
    }

    @Override
    public Mono<Iglesia> getIglesiaByName(String name) {
        return iglesiaDataRepository.findByNameEquals(name)
                .map(converter::toEntity);
    }

    @Override
    public Mono<Iglesia> saveIglesia(Iglesia iglesia) {
        return Mono.just(iglesia)
                .map(converter::toData)
                .flatMap(iglesiaDataRepository::save)
                .map(converter::toEntity);
    }

    @Override
    public Flux<DocumentoIdentidad> getDocumentosIdentidad() {
        return documentoIdentidadDataRepository.findAll()
                .map(converter::toEntity);
    }

    @Override
    public Mono<DocumentoIdentidad> getDocumentoIdentidadByName(String name) {
        return documentoIdentidadDataRepository.findByName(name)
                .map(converter::toEntity);
    }

    @Override
    public Mono<DocumentoIdentidad> getDocumentoIdentidadByIdType(String idType) {
        return documentoIdentidadDataRepository.findByIdType(idType)
                .map(converter::toEntity);
    }
}
