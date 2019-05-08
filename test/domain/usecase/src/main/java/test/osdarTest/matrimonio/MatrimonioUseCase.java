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

        return matrimonioRepository.getMarriageById(matrimonio.getId())
                .defaultIfEmpty(Matrimonio.builder().build())
                .filter(matrimonio1 -> matrimonio.getId() == null)
                .map(matrimonio1 -> generateObjectId())
                .flatMap(id -> {

                    final Mono<List<Contrayente>> contrayenteList = Flux.fromIterable(matrimonio.getContrayentes())
                            .flatMap(contrayente -> contrayenteRepository.saveContrayente(contrayente))
                            .collectList();

                    return Mono.just(matrimonioRepository.saveMarriage(Matrimonio.builder().id(id)
                    .contrayentes(contrayenteList)
                    .iglesia(matrimonio.getIglesia())
                    .pastor(matrimonio.getPastor())
                    .fecha(matrimonio.getFecha())
                    .marriageRegistrationNumber(matrimonio.getMarriageRegistrationNumber())
                    .notaria(matrimonio.getNotaria())
                    .actaNumber(matrimonio.getActaNumber()).build()));

                });




        return saveAgregates(matrimonio)
                .flatMap(matri -> matrimonioRepository.saveMarriage(matri));
    }

    public Mono<Matrimonio> saveAgregates(Matrimonio matrimonio){

        return Flux.fromIterable(matrimonio.getContrayentes())
        .map(contrayente -> contrayente.getId() == null ?
                contrayente.toBuilder().id(UUID.randomUUID().toString()).build() : contrayente )
        .flatMap(contrayente -> contrayenteRepository.saveContrayente(contrayente))
        .then(Mono.just(matrimonio));


        /*return Flux.fromIterable(matrimonio.getContrayentes())
                .map(contrayente -> contrayente.getId() == null ?
                        contrayente.toBuilder().id(UUID.randomUUID().toString()).build() : contrayente )
                .flatMap(contrayente -> contrayenteRepository.saveContrayente(contrayente))
                .then(Mono.just(matrimonio));*/

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
