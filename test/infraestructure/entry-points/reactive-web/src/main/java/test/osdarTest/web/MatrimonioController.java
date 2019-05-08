package test.osdarTest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.matrimonio.MatrimonioUseCase;
import test.osdarTest.matrimonio.entity.Matrimonio;

@RestController
@RequestMapping("matrimonio")
@CrossOrigin(value = "*")
public class MatrimonioController {

    @Autowired
    private MatrimonioUseCase matrimonioUseCase;

    @PostMapping
    public Mono<Matrimonio> saveMatrimonio(@RequestBody Matrimonio matrimonio) {
        return matrimonioUseCase.saveMatrimonio(matrimonio);
    }

    @GetMapping
    public Flux<Matrimonio> getAllMarriages() {
        return matrimonioUseCase.getAllMariiages();
    }

    @GetMapping("/pastor/{namePastor}")
    public Flux<Matrimonio> getByPastor(@PathVariable String namePastor) {
        return matrimonioUseCase.getMarriagesByPastor(namePastor);
    }

    @GetMapping("/iglesia/{nameIglesia}")
    public Flux<Matrimonio> getByIglesia(@PathVariable String nameIglesia) {
        return matrimonioUseCase.getMarriagesByIglesia(nameIglesia);
    }
}
