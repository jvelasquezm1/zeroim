package test.osdarTest.contrayente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.contrayente.gateway.ContrayenteRepository;

public class ContrayenteUseCase {

    private ContrayenteRepository contrayenteRepository;

    public ContrayenteUseCase(ContrayenteRepository contrayenteRepository) {
        this.contrayenteRepository = contrayenteRepository;
    }

    public Mono<Contrayente> saveContrayente(Contrayente contrayente) {
        return contrayenteRepository.saveContrayente(contrayente);
    }

    public Flux<Contrayente> getAllContrayentes() {
        return contrayenteRepository.getAllContrayentes();
    }

    public Mono<Contrayente> getContrayenteByDocumentNumber(String documentNumber) {
        return contrayenteRepository.getContrayenteByDocumentNumber(documentNumber);
    }
}
