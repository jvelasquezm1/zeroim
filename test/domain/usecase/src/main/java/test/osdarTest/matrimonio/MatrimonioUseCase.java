package test.osdarTest.matrimonio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.contrayente.entity.ContrayenteFactory;
import test.osdarTest.contrayente.gateway.ContrayenteRepository;
import test.osdarTest.generic.GenerateUniqueId;
import test.osdarTest.matrimonio.entity.Matrimonio;
import test.osdarTest.matrimonio.gateway.MatrimonioRepository;

public class MatrimonioUseCase {

    private MatrimonioRepository matrimonioRepository;
    private ContrayenteRepository contrayenteRepository;

    public MatrimonioUseCase(MatrimonioRepository matrimonioRepository, ContrayenteRepository contrayenteRepository) {
        this.matrimonioRepository = matrimonioRepository;
        this.contrayenteRepository = contrayenteRepository;
    }

    public Mono<Matrimonio> saveMatrimonio(Matrimonio matrimonio) {
        return saveAgregates(matrimonio)
                .flatMap(matri -> matrimonioRepository.saveMarriage(matri));
    }

    public Mono<Matrimonio> saveAgregates(Matrimonio matrimonio){
        return Flux.fromIterable(matrimonio.getContrayentes())
        .filter(contrayente -> contrayente.getId() == null)
        .switchIfEmpty(Mono.error(new Exception("Ya existe este contrayente")))
        .flatMap(contrayente -> contrayenteRepository.saveContrayente(contrayente))
        .then(Mono.just(matrimonio));
    }


    public Flux<Matrimonio> getAllMariiages() {
        return matrimonioRepository.getAllMarriages();
    }

    public Flux<Matrimonio> getMarriagesByPastor(String namePastor) {
        return matrimonioRepository.getMarriagesByPastor(namePastor);
    }

    public Flux<Matrimonio> getMarriagesByIglesia(String nameIglesia) {
        return matrimonioRepository.getMarriagesByIglesia(nameIglesia);
    }
}
