package test.osdarTest.maestros.maestros.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Notaria;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.gateway.MaestrosRepository;
import test.osdarTest.maestros.maestros.data.IglesiaDataRepository;
import test.osdarTest.maestros.maestros.data.NotariaDataRepository;
import test.osdarTest.maestros.maestros.data.PastorDataRepository;

@Repository
public class MaestrosRepositoryAdapter implements MaestrosRepository {

    @Autowired
    private ConverterMaestros converter;

    @Autowired
    private PastorDataRepository pastorDataRepository;

    @Autowired
    private IglesiaDataRepository iglesiaDataRepository;

    @Autowired
    private NotariaDataRepository notariaDataRepository;

    @Override
    public Flux<Pastor> getPastores() {
        return pastorDataRepository.findAll().map(converter::toEntity);
    }

    @Override
    public Mono<Pastor> getPastorByCedula(String cedula) {
        return pastorDataRepository.getPastorByCedula(cedula)
                .map(converter::toEntity);
    }


    @Override
    public Flux<Iglesia> getIglesias() {
        return iglesiaDataRepository.findAll()
                .map(converter::toEntity);
    }

    @Override
    public Mono<Iglesia> getIglesiaByName(String name) {
        return iglesiaDataRepository.findByNameMatchesRegex(name)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Notaria> getNotarias() {
        return notariaDataRepository.findAll()
                .map(converter::toEntity);
    }

    @Override
    public Mono<Notaria> getNotariaByName(String name) {
        return notariaDataRepository.findByNameMatchesRegex(name)
                .map(converter::toEntity);
    }
}
