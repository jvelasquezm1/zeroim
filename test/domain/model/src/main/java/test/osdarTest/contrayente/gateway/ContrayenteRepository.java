package test.osdarTest.contrayente.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.contrayente.entity.Contrayente;

import java.util.List;

public interface ContrayenteRepository {

    Mono<Contrayente> saveContrayente(Contrayente contrayente);

    Flux<Contrayente> getAllContrayentes();

    //Flux<Contrayente> getContrayentesByMarriage(String matrimonioPK); REVISAR

    Mono<Contrayente> getContrayenteByDocumentNumber(String documentNumber);
}
