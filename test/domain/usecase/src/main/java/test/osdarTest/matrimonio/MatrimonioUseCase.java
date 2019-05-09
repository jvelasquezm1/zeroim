package test.osdarTest.matrimonio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.contrayente.entity.ContrayenteFactory;
import test.osdarTest.contrayente.gateway.ContrayenteRepository;
import test.osdarTest.generic.GenerateUniqueId;
import test.osdarTest.matrimonio.entity.Matrimonio;
import test.osdarTest.matrimonio.gateway.MatrimonioRepository;

import java.util.List;
import java.util.UUID;

public class MatrimonioUseCase implements GenerateUniqueId{

    private MatrimonioRepository matrimonioRepository;
    private ContrayenteRepository contrayenteRepository;

    public MatrimonioUseCase(MatrimonioRepository matrimonioRepository, ContrayenteRepository contrayenteRepository) {
        this.matrimonioRepository = matrimonioRepository;
        this.contrayenteRepository = contrayenteRepository;
    }

    public Mono<Matrimonio> saveMatrimonio(Matrimonio matrimonio) {

        return Flux.fromIterable(matrimonio.getContrayentes())
                        .flatMap(contrayente -> contrayenteRepository.saveContrayente(contrayente))
                        .collectList()
                        .map(contrayentes -> matrimonio.toBuilder().contrayentes(contrayentes).build())
                        .flatMap(matrimonio1 -> matrimonioRepository.saveMarriage(matrimonio1));

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
