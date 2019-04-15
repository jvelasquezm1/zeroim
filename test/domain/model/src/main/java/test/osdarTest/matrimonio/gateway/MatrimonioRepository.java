package test.osdarTest.matrimonio.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.matrimonio.entity.Matrimonio;

public interface MatrimonioRepository {

    public Mono<Matrimonio> saveMarriage(Matrimonio matrimonio);

    public Flux<Matrimonio> getAllMarriages();

    public Flux<Matrimonio> getMarriagesByPastor(String namePastor);

    public Flux<Matrimonio> getMarriagesByIglesia(String nameIglesia);

    //public Mono<Void> deleeteMarriage(Matrimonio matrimonio); Check

}
