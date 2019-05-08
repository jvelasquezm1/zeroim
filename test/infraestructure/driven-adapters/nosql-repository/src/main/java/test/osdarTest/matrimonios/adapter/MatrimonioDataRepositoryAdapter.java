package test.osdarTest.matrimonios.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.matrimonio.entity.Matrimonio;
import test.osdarTest.matrimonio.gateway.MatrimonioRepository;
import test.osdarTest.matrimonios.data.MatrimonioDataRepository;

@Repository
public class MatrimonioDataRepositoryAdapter implements MatrimonioRepository {

    @Autowired
    ConverterMatrimonio converter;

    @Autowired
    private MatrimonioDataRepository matrimonioDataRepository;

    @Override
    public Mono<Matrimonio> saveMarriage(Matrimonio matrimonio) {
        return Mono.just(matrimonio)
                .map(converter::toData)
                .flatMap(matrimonioDataRepository::save)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Matrimonio> getAllMarriages() {
        return matrimonioDataRepository.findAll()
                .map(converter::toEntity);
    }

    @Override
    public Mono<Matrimonio> getMarriageById(String id) {
        return matrimonioDataRepository.findById(id)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Matrimonio> getMarriagesByPastor(String namePastor) {
        return matrimonioDataRepository.findByPastor_Names(namePastor)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Matrimonio> getMarriagesByIglesia(String nameIglesia) {
        return matrimonioDataRepository.findByIglesia_Name(nameIglesia)
                .map(converter::toEntity);
    }
}
