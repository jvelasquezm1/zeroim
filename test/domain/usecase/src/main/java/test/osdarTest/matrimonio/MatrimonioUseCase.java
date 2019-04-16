package test.osdarTest.matrimonio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.matrimonio.entity.Matrimonio;
import test.osdarTest.matrimonio.gateway.MatrimonioRepository;

public class MatrimonioUseCase {

    private MatrimonioRepository matrimonioRepository;

    public MatrimonioUseCase(MatrimonioRepository matrimonioRepository) {
        this.matrimonioRepository = matrimonioRepository;
    }

    public Mono<Matrimonio> saveMatrimonio(Matrimonio matrimonio) {
        return matrimonioRepository.saveMarriage(matrimonio);
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
