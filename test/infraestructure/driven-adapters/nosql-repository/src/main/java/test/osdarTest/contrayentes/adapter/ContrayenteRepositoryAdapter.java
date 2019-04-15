package test.osdarTest.contrayentes.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.contrayente.gateway.ContrayenteRepository;
import test.osdarTest.contrayentes.data.ContrayenteDataRepository;

@Repository
public class ContrayenteRepositoryAdapter implements ContrayenteRepository {

    @Autowired
    ConverterContrayente converter;

    @Autowired
    private ContrayenteDataRepository contrayenteDataRepository;

    @Override
    public Mono<Contrayente> saveContrayente(Contrayente contrayente) {
        return Mono.just(contrayente)
                .map(converter::toData)
                .flatMap(contrayenteDataRepository::save)
                .map(converter::toEntity);
    }

    @Override
    public Flux<Contrayente> getAllContrayentes() {
        return contrayenteDataRepository.findAll()
                .map(converter::toEntity);
    }

    @Override
    public Mono<Contrayente> getContrayenteByDocumentNumber(String documentNumber) {
        return contrayenteDataRepository.getByDocumentNumber(documentNumber)
                .map(converter::toEntity);
    }

}