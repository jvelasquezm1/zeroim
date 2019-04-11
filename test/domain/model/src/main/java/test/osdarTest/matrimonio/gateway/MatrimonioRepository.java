package test.osdarTest.matrimonio.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.matrimonio.entity.Matrimonio;

public interface MatrimonioRepository {

    public Mono<Void> saveMarriage();

    public Flux<Matrimonio> getAllMarriages();

    public Flux<Matrimonio> getMarriagesByPastor(String namePastor);

    public Flux<Matrimonio> getMarriagesByIglesia(String nameIglesia);

}
