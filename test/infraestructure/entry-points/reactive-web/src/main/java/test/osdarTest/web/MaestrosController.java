package test.osdarTest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.usecase.MaestrosUseCase;

@RestController
@RequestMapping("maestros")
public class MaestrosController {

    @Autowired
    private MaestrosUseCase maestrosUseCase;

    @GetMapping("/pastores")
    public Flux<Pastor> getPastores() {
        return maestrosUseCase.getPastores();
    }

    @GetMapping("/pastor/{idDocument}")
    public Mono<Pastor> getPastorByIdDocument(@PathVariable String idDocument) {
        return maestrosUseCase.getPastorByIdDocument(idDocument);
    }

    @GetMapping("/iglesias")
    public Flux<Iglesia> getIglesias() {
        return maestrosUseCase.getIglesias();
    }

    @GetMapping("/iglesia/{name}")
    public Mono<Iglesia> getIglesiaByName(@PathVariable String name) {
        return maestrosUseCase.getIglesiasByName(name);
    }
}
